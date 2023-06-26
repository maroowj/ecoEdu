package com.muzisoft.education.domain.program;

import com.muzisoft.education.domain.category.CategoryEntity;
import com.muzisoft.education.domain.category.CategoryRepository;
import com.muzisoft.education.web.api.dto.admin.program.ProgramDetailResponse;
import com.muzisoft.education.web.api.dto.admin.program.ProgramListRequest;
import com.muzisoft.education.web.api.dto.admin.program.ProgramListResponse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.ObjectUtils;

import java.util.List;

import static com.muzisoft.education.domain.category.QCategoryEntity.categoryEntity;
import static com.muzisoft.education.domain.company.QCompanyEntity.companyEntity;
import static com.muzisoft.education.domain.program.QProgramEntity.programEntity;


public class ProgramQueryRepositoryImpl extends QuerydslRepositorySupport implements ProgramQueryRepository {

    private final JPAQueryFactory queryFactory;
    private final CategoryRepository categoryRepository;

    public ProgramQueryRepositoryImpl(JPAQueryFactory queryFactory, CategoryRepository categoryRepository) {
        super(ProgramEntity.class);
        this.queryFactory = queryFactory;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<ProgramListResponse> programList(ProgramListRequest request, Pageable pageable) {

        JPAQuery<ProgramListResponse> query = queryFactory
                .select(Projections.constructor(ProgramListResponse.class,
                        Expressions.constant(0),
                        programEntity.programSeq,
                        programEntity.title,
                        companyEntity.name,
                        categoryEntity.cateName,
                        programEntity.target,
                        programEntity.theme,
                        programEntity.type
                        ))
                .from(programEntity)
                .leftJoin(companyEntity).on(programEntity.company.eq(companyEntity))
                .leftJoin(categoryEntity).on(companyEntity.category.eq(categoryEntity))
                .where(
                        programEntity.withdrawal.isFalse(),
                        searchProgramByType(request.getSearchType()),
                        searchProgramByTheme(request.getSearchTheme()),
                        searchProgramByTarget(request.getSearchTarget()),
                        searchProgramByName(request.getQuery()),
                        searchByCompanySeq(request.getCompanySeq())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(programEntity.getType(), programEntity.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        QueryResults<ProgramListResponse> result = query.fetchResults();

        return new PageImpl(result.getResults(), pageable, result.getTotal());

    }

    @Override
    public List<ProgramEntity> findByCategoryAndWithdrawal(String categorySeq) {
        return queryFactory.select(
                    programEntity
                )
                .from(programEntity)
                .where(
                        programEntity.withdrawal.isFalse().
                                and(programEntity.theme.contains(categorySeq)
                                        .or(programEntity.target.contains(categorySeq))
                                                .or(programEntity.type.contains(categorySeq)))

                )
                .fetch();
    }

    @Override
    public ProgramDetailResponse programDetail(String programSeq) {
        return queryFactory.select(Projections.constructor(ProgramDetailResponse.class,
                programEntity.programSeq,
                programEntity.title,
                programEntity.script,
                programEntity.company.companySeq,
                programEntity.target,
                programEntity.theme,
                programEntity.type,
//                programEntity.startTime,
//                programEntity.endTime,
//                programEntity.oneTimeType,
                programEntity.oneTime,
//                programEntity.memberLimit,
                programEntity.memberCount,
                programEntity.schedule,
                programEntity.method,
                programEntity.cost,
                programEntity.costType,
                programEntity.tel,
                programEntity.telType,
                programEntity.img1,
                programEntity.img2
                ))
                .from(programEntity)
                .where(
                       programEntity.programSeq.eq(programSeq),
                       programEntity.withdrawal.isFalse()
                )
                .fetchOne();
    }

    private Predicate searchProgramByType(String type) {
        if (ObjectUtils.isEmpty(type)) {
            return null;
        } else {
            return programEntity.type.contains(type);
        }
    }

    private Predicate searchProgramByTheme(String theme) {
        if (ObjectUtils.isEmpty(theme)) {
            return null;
        } else {
            return programEntity.theme.contains(theme);
        }
    }

    private Predicate searchProgramByTarget(String target) {
        CategoryEntity category = categoryRepository.findByCateTypeAndCateName("교육대상", "전체");
        String wholeSeq="";
        if(category!=null){
            wholeSeq = category.getCateSeq();
        }
        BooleanBuilder builder = new BooleanBuilder();
        if (ObjectUtils.isEmpty(target)) {
            return null;
        } else {
            builder.and(programEntity.target.contains(target).or(programEntity.target.contains(wholeSeq)));
        }
        return builder;
    }

    // 프로그램명으로 검색
    private Predicate searchProgramByName(String keyword) {
        if (ObjectUtils.isEmpty(keyword)) {
            return null;
        } else {
            return programEntity.title.contains(keyword);
        }
    }

    private Predicate searchByCompanySeq(String companySeq) {
        BooleanBuilder builder = new BooleanBuilder();
        if (ObjectUtils.isEmpty(companySeq)) {
            return null;
        }else {
            builder.and(programEntity.company.companySeq.eq(companySeq));
        }
        return builder;
    }

}
