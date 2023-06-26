package com.muzisoft.education.web.api.user;

import com.muzisoft.education.web.api.dto.admin.request.RequestDetailResponse;
import com.muzisoft.education.web.api.dto.admin.request.RequestListRequest;
import com.muzisoft.education.web.api.dto.admin.request.RequestListResponse;
import com.muzisoft.education.web.api.dto.users.request.RequestListResponseForUser;
import com.muzisoft.education.web.api.dto.users.request.RequestSaveRequest;
import com.muzisoft.education.web.api.dto.users.request.RequestUserDetailRequest;
import com.muzisoft.education.web.service.request.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user/api")
@RequiredArgsConstructor
public class RequestUserApiController {

    private final RequestService requestService;

    // 수정요청 신규등록
    @PostMapping("/request/save")
    public void requestInsert(@RequestBody RequestSaveRequest request) {
        requestService.requestInsert(request);
    }

    // 수정요청 상세조회
    @PostMapping("/request/detail")
    public RequestDetailResponse requestUserDetail(@RequestBody RequestUserDetailRequest request) {
        return requestService.requestUserDetail(request);
    }

    // 수정요청 목록조회
    @GetMapping("/request/list")
    public Page<RequestListResponseForUser> requestList(RequestListRequest request, @PageableDefault(sort = "requestSeq", direction = Sort.Direction.DESC) Pageable pageable) {
        return requestService.userRequestList(request, pageable);
    }


}
