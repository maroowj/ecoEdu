package com.muzisoft.education.domain.category;

import com.muzisoft.education.web.api.dto.admin.category.CategoryListResponse;
import com.muzisoft.education.web.api.dto.users.category.CategoryUserListResponse;
import com.muzisoft.education.web.api.dto.users.category.CategoryUserSaveRequest;
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


public class CategoryQueryRepositoryImpl extends QuerydslRepositorySupport implements CategoryQueryRepository {

    private final JPAQueryFactory queryFactory;

    public CategoryQueryRepositoryImpl(JPAQueryFactory queryFactory) {
        super(CategoryEntity.class);
        this.queryFactory = queryFactory;
    }

    /** admin: 카테고리 목록조회 **/
    @Override
    public Page<CategoryListResponse> categoryList(String cateType, Pageable pageable) {

        JPAQuery<CategoryListResponse> query = queryFactory
                .select(Projections.constructor(CategoryListResponse.class,
                        Expressions.constant(0),
                        categoryEntity.cateSeq,
                        categoryEntity.cateName,
                        categoryEntity.script
                        ))
                .from(categoryEntity)
                .where(
                        searchCategoryByType(cateType)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(categoryEntity.getType(), categoryEntity.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        QueryResults<CategoryListResponse> result = query.fetchResults();

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

    private Predicate searchCategoryByType(String cateType) {
        if (ObjectUtils.isEmpty(cateType)) {
            return null;
        } else {
            return categoryEntity.cateType.eq(cateType);
        }
    }


}
