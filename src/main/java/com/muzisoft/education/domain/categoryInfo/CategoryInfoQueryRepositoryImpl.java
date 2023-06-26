package com.muzisoft.education.domain.categoryInfo;

import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoListRequest;
import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoProgramResponse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
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
import static com.muzisoft.education.domain.categoryInfo.QCategoryInfoEntity.categoryInfoEntity;
import static com.muzisoft.education.domain.company.QCompanyEntity.companyEntity;
import static com.muzisoft.education.domain.program.QProgramEntity.programEntity;


public class CategoryInfoQueryRepositoryImpl extends QuerydslRepositorySupport implements CategoryInfoQueryRepository {

    private final JPAQueryFactory queryFactory;

    public CategoryInfoQueryRepositoryImpl(JPAQueryFactory queryFactory) {
        super(CategoryInfoEntity.class);
        this.queryFactory = queryFactory;
    }

    /** user: 검색결과 목록조회 **/
    @Override
    public Page<CategoryInfoProgramResponse> userSearchResultList(CategoryInfoListRequest request, Pageable pageable) {

        JPAQuery<CategoryInfoProgramResponse> query = queryFactory
                .select(Projections.constructor(CategoryInfoProgramResponse.class,
                        programEntity.programSeq,
                        companyEntity.companySeq,
                        programEntity.title,
                        programEntity.company.name,
                        companyEntity.addressDetail,
                        companyEntity.tel,
                        companyEntity.homeUrl,
                        companyEntity.cafeUrl,
                        companyEntity.email,
                        programEntity.area,
                        programEntity.target,
                        programEntity.theme,
                        programEntity.type,
                        programEntity.memberCount,
                        programEntity.schedule,
                        programEntity.script,
                        Expressions.constant("-"),
                        Expressions.constant("-"),
                        programEntity.method
                        ))
                .from(categoryInfoEntity)
                .leftJoin(categoryInfoEntity.category, categoryEntity)
                .leftJoin(categoryInfoEntity.program, programEntity)
                .leftJoin(programEntity.company, companyEntity)
                .where(
                    searchCategoryByCateType(request.getCateType()),
                    searchCategoryByCateName(request.getCateType(), request.getCateName()),
                    searchCategoryByKeyword(request.getSearchType(), request.getKeyword())
                )
                .groupBy(searchGroupByType(request.getSearchType()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());


        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(categoryInfoEntity.getType(), categoryInfoEntity.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        QueryResults<CategoryInfoProgramResponse> result = query.fetchResults();

        return new PageImpl(result.getResults(), pageable, result.getTotal());

    }

    /** user: 카테고리별 목록조회
    @Override
    public Page<CategoryUserListResponse> categoryUserList(CategoryUserSaveRequest request, Pageable pageable) {

        JPAQuery<CategoryUserListResponse> query = queryFactory
                .select(Projections.constructor(CategoryUserListResponse.class,

                ))
                .from(categoryEntity)
                .where(
                        categoryEntity.withdrawal.isFalse()
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(categoryEntity.getType(), categoryEntity.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        QueryResults<CategoryUserListResponse> result = query.fetchResults();

        return new PageImpl(result.getResults(), pageable, result.getTotal());

    }
     **/

    private Predicate searchCategoryByCateType(String cateType) {
        if (ObjectUtils.isEmpty(cateType)) {
            return null;
        } else {
            return categoryEntity.cateType.eq(cateType);
        }
    }

    private Predicate searchCategoryByCateName(String cateType, List<String> cateNames) {
        BooleanBuilder builder = new BooleanBuilder();
        switch (cateType) {
            case "지역":
                if (ObjectUtils.isEmpty(cateNames)) {
                    return null;
                }else if(cateNames.size()==0) {
                    return null;
                }else {
                    for(String cateName : cateNames) {
                        builder.or(categoryEntity.cateName.eq(cateName));
                    }
                    builder.or(categoryEntity.cateName.contains("전체"));
                    builder.or(categoryEntity.cateName.contains("전연령"));
                }
                break;
            case "교육대상":
                if (ObjectUtils.isEmpty(cateNames)) {
                    return null;
                }else if(cateNames.size()==0) {
                    return null;
                }else {
                    for(String cateName : cateNames) {
                        builder.or(categoryEntity.cateName.contains(cateName));
                    }
                    builder.or(categoryEntity.cateName.contains("전체"));
                    builder.or(categoryEntity.cateName.contains("전연령"));
                }
                break;
            case "교육테마":
            case "교육유형":
                if (ObjectUtils.isEmpty(cateNames)) {
                    return null;
                }else if(cateNames.size()==0) {
                    return null;
                }else {
                    for(String cateName : cateNames) {
                        builder.or(categoryEntity.cateName.contains(cateName));
                    }
                }
                break;
        }


        return builder;
    }

    private Predicate searchCategoryByCategory(String cateType, List<String> cateNames) {
        BooleanBuilder builder = new BooleanBuilder();
        if (ObjectUtils.isEmpty(cateNames)) {
            return null;
        }else if(cateNames.size()==0) {
            return null;
        }else {
            for(String cateName : cateNames) {
                builder.or(categoryEntity.cateName.eq(cateName));
            }
        }
        return builder;
    }


    private Predicate searchCategoryByKeyword(String searchType, String keyword) {
        BooleanBuilder builder = new BooleanBuilder();
//        System.out.println("keyword=" + keyword);
        if (ObjectUtils.isEmpty(keyword)) {
            if(searchType.equals("program")) {
                builder.and(programEntity.title.contains(""));
            }else if(searchType.equals("company")) {
                builder.and(companyEntity.name.contains(""));
            }
        }else {
            if(searchType.equals("program")) {
                builder.and(programEntity.title.contains(keyword));
            }else if(searchType.equals("company")) {
                builder.and(companyEntity.name.contains(keyword));
            }
        }
        return builder;
    }

    /*private Predicate searchByEtc(int etc, String etcCateName) {
        BooleanBuilder builder = new BooleanBuilder();
        if(etc==0) {
            builder.and(categoryEntity.etc.eq(false));
        }else if(etc==1) {
            builder.and(categoryEntity.etc.eq(true)).and(categoryEntity.cateName.contains(etcCateName));
        }
        return builder;
    }*/


    private StringPath searchGroupByType(String searchType) {
        if (ObjectUtils.isEmpty(searchType)) {
            return null;
        } else if(searchType.equals("program")) {
            return programEntity.programSeq;
        } else if(searchType.equals("company")) {
            return companyEntity.companySeq;
        } else {
            return null;
        }
    }

}
