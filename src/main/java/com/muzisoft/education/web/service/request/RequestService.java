package com.muzisoft.education.web.service.request;

import com.muzisoft.education.domain.category.CategoryRepository;
import com.muzisoft.education.domain.company.CompanyEntity;
import com.muzisoft.education.domain.company.CompanyRepository;
import com.muzisoft.education.domain.file.FileManagerRepository;
import com.muzisoft.education.domain.program.ProgramEntity;
import com.muzisoft.education.domain.program.ProgramRepository;
import com.muzisoft.education.domain.request.RequestEntity;
import com.muzisoft.education.domain.request.RequestRepository;
import com.muzisoft.education.web.api.dto.admin.request.RequestListRequest;
import com.muzisoft.education.web.api.dto.users.request.RequestListResponseForUser;
import com.muzisoft.education.web.api.dto.users.request.RequestSaveRequest;
import com.muzisoft.education.web.api.dto.admin.request.RequestUpdateRequest;
import com.muzisoft.education.web.api.dto.admin.request.RequestDetailResponse;
import com.muzisoft.education.web.api.dto.admin.request.RequestListResponse;
import com.muzisoft.education.web.api.dto.users.request.RequestUserDetailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestService {

    private final ProgramRepository programRepository;
    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;
    private final RequestRepository requestRepository;
    private final FileManagerRepository fileManagerRepository;

    private final PasswordEncoder passwordEncoder;

    /** admin: 수정요청 목록조회 **/
    @Transactional
    public Page<RequestListResponse> requestList(RequestListRequest request, Pageable pageable) {
        Page<RequestListResponse> result = requestRepository.requestList(request, pageable);

        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int totalCount = (int) result.getTotalElements();

        int dec = pageSize * pageNumber;

        for(RequestListResponse response : result.getContent()) {
            response.setRowNum(totalCount-dec);
            dec++;
        }
        return result;
    }

    /** admin: 수정요청 상세조회 **/
    @Transactional
    public RequestDetailResponse requestDetail(String requestSeq) {
        return requestRepository.requestDetail(requestSeq);
    }

    /** admin: 수정요청 정보수정(답변추가) **/
    @Transactional
    public void requestUpdate(RequestUpdateRequest request) {

        RequestEntity requestEntity = requestRepository.findById(request.getRequestSeq()).orElseThrow(() -> new RuntimeException("수정요청 정보를 찾을 수 없습니다."));

        System.out.println("request response = " + request.getResponse());

        if (request.getState() != null && !request.getState().equals("")) {
            requestEntity.updateState(request.getState());
        }
        if (request.getResponse() != null && !request.getResponse().equals("")) {
            requestEntity.updateResponse(request.getResponse());
        }
        if (request.getImpossible() != null && !request.getImpossible().equals("")) {
            requestEntity.updateImpossible(request.getImpossible());
        }
        if (request.getDetail() != null && !request.getDetail().equals("")) {
            requestEntity.updateDetail(request.getDetail());
        }
    }

    /** admin: 수정요청 상태수정 **/
    @Transactional
    public void requestState(List<String> requestSeq, String state, String impossible, String detail) {
        for (String seq: requestSeq) {
            RequestEntity requestEntity = requestRepository.findById(seq).orElseThrow(() -> new RuntimeException("수정요청 정보를 찾을 수 없습니다."));
            switch (state) {
                case "처리완료":
                    requestEntity.updateState("처리완료");
                    break;
                case "요청확인":
                    requestEntity.updateState("요청확인");
                    break;
                case "처리불가" :
                    requestEntity.updateState("처리불가");
                    break;
            }
            if (impossible != null && !impossible.equals("")) {
                requestEntity.updateImpossible(impossible);
            }
            if (detail != null && !detail.equals("")) {
                requestEntity.updateDetail(detail);
            }
        }
    }

    /** admin: 수정요청 상태수정 **/
    @Transactional
    public void requestDelete(String requestSeq) {
        RequestEntity requestEntity = requestRepository.findById(requestSeq).orElseThrow(() -> new RuntimeException("수정요청 정보를 찾을 수 없습니다."));
        requestEntity.deleteRequest();
    }

    /** user: 수정요청 신규등록 **/
    @Transactional
    public void requestInsert(RequestSaveRequest request) {

        CompanyEntity company = null;
        ProgramEntity program = null;

        if (request.getCompanySeq() != null && !request.getCompanySeq().equals("")) {
            company = companyRepository.findById(request.getCompanySeq()).orElseThrow(() -> new RuntimeException("단체 정보를 찾을 수 없습니다."));
        }

        if (request.getProgramSeq() != null && !request.getProgramSeq().equals("")) {
            program = programRepository.findById(request.getProgramSeq()).orElseThrow(() -> new RuntimeException("프로그램 정보를 찾을 수 없습니다."));
            company = program.getCompany();
        }

        boolean requestType = false;
        if (request.getRequestType() == 1) {
            requestType = true;
        }

        RequestEntity requestEntity = requestRepository.save(

                RequestEntity.builder()
                        .company(company)
                        .program(program)
                        .requestType(requestType)
                        .writer(request.getWriter())
                        .request(request.getRequest())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .grade(request.getGrade())
                        .phone(request.getPhone())
                        .email(request.getEmail())
                        .impossible(request.getImpossible())
                        .requestUrl(request.getRequestUrl())
                        .state("미확인")
                        .build()
        );
    }

    /** user: 수정요청 상세조회 **/
    @Transactional
    public RequestDetailResponse requestUserDetail(RequestUserDetailRequest request) {
        RequestEntity requestEntity = requestRepository.findById(request.getRequestSeq()).orElseThrow(() -> new RuntimeException("수정요청 정보를 찾을 수 없습니다."));

        if (passwordEncoder.matches(request.getPassword(), requestEntity.getPassword())) {
            return requestRepository.requestDetail(request.getRequestSeq());
        } else {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

    }

    /** user: 수정요청 목록조회 **/
    @Transactional
    public Page<RequestListResponseForUser> userRequestList(RequestListRequest request, Pageable pageable) {
        Page<RequestListResponseForUser> result = requestRepository.userRequestList(request, pageable);

        for(RequestListResponseForUser response : result.getContent()) {
            StringBuffer sb = new StringBuffer();
            sb.append(response.getWriter());
            response.setWriter(sb.replace(1,2, "*").toString());
        }
        return result;
    }


}
