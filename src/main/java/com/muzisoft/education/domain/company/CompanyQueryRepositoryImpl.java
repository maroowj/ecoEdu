package com.muzisoft.education.domain.company;

import com.muzisoft.education.web.api.dto.admin.company.CompanyDetailResponse;
import com.muzisoft.education.web.api.dto.admin.company.CompanyListResponse;
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

import static com.muzisoft.education.domain.category.QCategoryEntity.categoryEntity;
import static com.muzisoft.education.domain.company.QCompanyEntity.companyEntity;
import static com.muzisoft.education.domain.file.QEFileManager.eFileManager;


public class CompanyQueryRepositoryImpl extends QuerydslRepositorySupport implements CompanyQueryRepository {

    private final JPAQueryFactory queryFactory;

    public CompanyQueryRepositoryImpl(JPAQueryFactory queryFactory) {
        super(CompanyEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<CompanyListResponse> companyList(String cateSeq, String keyword, String cateName, Pageable pageable) {

        JPAQuery<CompanyListResponse> query = queryFactory
                .select(Projections.constructor(CompanyListResponse.class,
                        Expressions.constant(0),
                        companyEntity.companySeq,
                        companyEntity.name,
                        companyEntity.category.cateName,
                        companyEntity.addressDetail,
                        companyEntity.tel,
                        companyEntity.type,
                        companyEntity.startDate,
                        companyEntity.homeUrl,
                        companyEntity.cafeUrl,
                        companyEntity.email
                        ))
                .from(companyEntity)
                .where(
                        companyEntity.withdrawal.isFalse(),
                        searchCategoryByType(cateSeq),
                        searchCompanyByName(keyword),
                        searchCompanyByCateName(cateName)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(companyEntity.getType(), companyEntity.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        QueryResults<CompanyListResponse> result = query.fetchResults();

        return new PageImpl(result.getResults(), pageable, result.getTotal());

    }

    @Override
    public CompanyDetailResponse companyDetail(String companySeq) {
        return queryFactory.select(Projections.constructor(CompanyDetailResponse.class,
                companyEntity.companySeq,
                companyEntity.name,
                companyEntity.script,
                categoryEntity.cateName,
                companyEntity.addressDetail,
                companyEntity.tel,
                companyEntity.type,
                companyEntity.startDate,
                companyEntity.homeUrl,
                companyEntity.cafeUrl,
                companyEntity.img,
                companyEntity.createNo
                ))
                .from(companyEntity)
                .leftJoin(companyEntity.category, categoryEntity)
                .leftJoin(companyEntity.img, eFileManager)
                .where(
                        companyEntity.companySeq.eq(companySeq),
                        companyEntity.withdrawal.isFalse()
                )
                .fetchOne();
    }

    private Predicate searchCategoryByType(String cateSeq) {
        if (ObjectUtils.isEmpty(cateSeq)) {
            return null;
        } else {
            return companyEntity.category.cateSeq.eq(cateSeq);
        }
    }

    private Predicate searchCompanyByName(String keyword) {
        if (ObjectUtils.isEmpty(keyword)) {
            return null;
        } else {
            return companyEntity.name.contains(keyword);
        }
    }

    private Predicate searchCompanyByCateName(String cateName) {
        if (ObjectUtils.isEmpty(cateName)) {
            return null;
        } else {
            return companyEntity.category.cateName.eq(cateName);
        }
    }
    // 키워드 검색 구분이 다양해질 때 사용
//    private Predicate searchCompanyByName(String type, String keyword) {
//        if (ObjectUtils.isEmpty(type)) {
//            return null;
//        } else if (type.equals("companyName")){
//            return companyEntity.name.contains(keyword);
//        } else {
//            return null;
//        }
//    }

}
