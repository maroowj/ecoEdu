package com.muzisoft.education.domain.request;

import com.muzisoft.education.web.api.dto.admin.request.RequestListRequest;
import com.muzisoft.education.web.api.dto.admin.request.RequestDetailResponse;
import com.muzisoft.education.web.api.dto.admin.request.RequestListResponse;
import com.muzisoft.education.web.api.dto.users.request.RequestListResponseForUser;
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

import static com.muzisoft.education.domain.company.QCompanyEntity.companyEntity;
import static com.muzisoft.education.domain.program.QProgramEntity.programEntity;
import static com.muzisoft.education.domain.request.QRequestEntity.requestEntity;


public class RequestQueryRepositoryImpl extends QuerydslRepositorySupport implements RequestQueryRepository {

    private final JPAQueryFactory queryFactory;

    public RequestQueryRepositoryImpl(JPAQueryFactory queryFactory) {
        super(RequestEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<RequestListResponse> requestList(RequestListRequest request, Pageable pageable) {

        JPAQuery<RequestListResponse> query = queryFactory
                .select(Projections.constructor(RequestListResponse.class,
                        Expressions.constant(0),
                        requestEntity.requestSeq,
                        requestEntity.requestType,
                        requestEntity.company.name,
                        requestEntity.program.title,
                        requestEntity.state,
                        Expressions.stringTemplate("DATE_FORMAT({0}, '%Y-%m-%d %T')", requestEntity.createdAt),
                        requestEntity.writer,
                        requestEntity.phone
                        ))
                .from(requestEntity)
                .leftJoin(requestEntity.company, companyEntity)
                .leftJoin(requestEntity.program, programEntity)
                .where(
                        requestEntity.withdrawal.isFalse(),
                        searchRequestByType(request.getRequestType()),
                        (requestEntity.company.name.contains(request.getKeyword()).or(requestEntity.program.title.contains(request.getKeyword()))),
                        searchRequestByStatus(request.getStatus())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(requestEntity.getType(), requestEntity.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        QueryResults<RequestListResponse> result = query.fetchResults();

        return new PageImpl(result.getResults(), pageable, result.getTotal());

    }

    @Override
    public RequestDetailResponse requestDetail(String requestSeq) {
        return queryFactory.select(Projections.constructor(RequestDetailResponse.class,
                requestEntity.requestSeq,
                companyEntity.name,
                programEntity.title,
                requestEntity.state,
                requestEntity.request,
                requestEntity.requestType,
                requestEntity.writer,
                Expressions.stringTemplate("DATE_FORMAT({0}, '%Y-%m-%d %T')", requestEntity.createdAt),
                requestEntity.grade,
                requestEntity.phone,
                requestEntity.impossible,
                requestEntity.email,
                requestEntity.detail,
                requestEntity.requestUrl
                ))
                .from(requestEntity)
                .leftJoin(requestEntity.company, companyEntity)
                .leftJoin(requestEntity.program, programEntity)
                .where(
                    requestEntity.withdrawal.isFalse(),
                    requestEntity.requestSeq.eq(requestSeq)
                )
                .fetchOne();
    }

    @Override
    public Page<RequestListResponseForUser> userRequestList(RequestListRequest request, Pageable pageable) {
        JPAQuery<RequestListResponseForUser> query = queryFactory
                .select(Projections.constructor(RequestListResponseForUser.class,
                        requestEntity.requestSeq,
                        requestEntity.requestType,
                        requestEntity.company.name,
                        requestEntity.program.title,
                        requestEntity.state,
                        requestEntity.writer
                ))
                .from(requestEntity)
                .leftJoin(requestEntity.company, companyEntity)
                .leftJoin(requestEntity.program, programEntity)
                .where(
                        requestEntity.withdrawal.isFalse(),
                        searchRequestByType(request.getRequestType()),
                        (requestEntity.company.name.contains(request.getKeyword()).or(requestEntity.program.title.contains(request.getKeyword())))
//                        searchRequestByStatus(request.getStatus())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(requestEntity.getType(), requestEntity.getMetadata());
            query.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        QueryResults<RequestListResponseForUser> result = query.fetchResults();

        return new PageImpl(result.getResults(), pageable, result.getTotal());
    }

    private Predicate searchRequestByType(Boolean requestType) {
        if (requestType==null) {
            return null;
        } else if (requestType==true) {
            return requestEntity.requestType.isTrue();
        } else {
            return requestEntity.requestType.isFalse();
        }
    }

    // 키워드 검색 구분이 다양해질 때 사용
    private Predicate searchRequestByName(String type, String keyword) {
        if (ObjectUtils.isEmpty(type)) {
            return null;
        } else if (type.equals("company")){
            return requestEntity.company.name.contains(keyword);
        } else if (type.equals("program")){
            return requestEntity.program.title.contains(keyword);
        } else {
            return null;
        }
    }

    private Predicate searchRequestByStatus(String status) {
        if (ObjectUtils.isEmpty(status)) {
            return null;
        } else if (status.equals("미확인")){
            return requestEntity.state.eq(status);
        } else if (status.equals("요청확인")){
            return requestEntity.state.eq(status);
        } else if (status.equals("처리불가")){
            return requestEntity.state.eq(status);
        } else if (status.equals("처리완료")){
            return requestEntity.state.eq(status);
        } else {
            return null;
        }
    }

}
