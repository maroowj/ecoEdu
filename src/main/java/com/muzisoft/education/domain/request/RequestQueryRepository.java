package com.muzisoft.education.domain.request;

import com.muzisoft.education.web.api.dto.admin.request.RequestListRequest;
import com.muzisoft.education.web.api.dto.admin.request.RequestDetailResponse;
import com.muzisoft.education.web.api.dto.admin.request.RequestListResponse;
import com.muzisoft.education.web.api.dto.users.request.RequestListResponseForUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RequestQueryRepository {

    Page<RequestListResponse> requestList(RequestListRequest request, Pageable pageable);

    RequestDetailResponse requestDetail(String requestSeq);

    Page<RequestListResponseForUser> userRequestList(RequestListRequest request, Pageable pageable);
}
