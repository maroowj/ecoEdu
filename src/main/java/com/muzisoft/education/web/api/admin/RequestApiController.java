package com.muzisoft.education.web.api.admin;

import com.muzisoft.education.web.api.dto.admin.request.RequestListRequest;
import com.muzisoft.education.web.api.dto.admin.request.RequestUpdateRequest;
import com.muzisoft.education.web.api.dto.admin.request.RequestDetailResponse;
import com.muzisoft.education.web.api.dto.admin.request.RequestListResponse;
import com.muzisoft.education.web.service.request.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/api")
@RequiredArgsConstructor
public class RequestApiController {

    private final RequestService requestService;

    // 수정요청 목록조회
    @GetMapping("/request/list")
    public Page<RequestListResponse> requestList(RequestListRequest request, @PageableDefault(sort = "requestSeq", direction = Sort.Direction.DESC) Pageable pageable) {
        return requestService.requestList(request, pageable);
    }

    // 수정요청 상세조회
    @GetMapping("/request/detail")
    public RequestDetailResponse requestDetail(String requestSeq) {
        return requestService.requestDetail(requestSeq);
    }

    // 수정요청 정보수정(답변추가)
    @PostMapping("/request/update")
    public void requestUpdate(@RequestBody RequestUpdateRequest request) {
        requestService.requestUpdate(request);
    }

    // 수정요청 상태수정
    @GetMapping("/request/state")
    @ResponseStatus(HttpStatus.CREATED)
    public void requestState(@RequestParam(value="requestSeq[]") List<String> requestSeq, String state, String impossible, String detail) {
        requestService.requestState(requestSeq, state, impossible, detail);
    }

    // 수정요청 삭제
    @GetMapping("/request/delete")
    public void requestDelete(String requestSeq) {
        requestService.requestDelete(requestSeq);
    }
}
