package com.muzisoft.education.web.api.admin;

import com.muzisoft.education.web.api.dto.admin.company.CompanyDetailResponse;
import com.muzisoft.education.web.api.dto.admin.company.CompanyListResponse;
import com.muzisoft.education.web.api.dto.admin.company.CompanySaveRequest;
import com.muzisoft.education.web.api.dto.admin.company.CompanyUpdateRequest;
import com.muzisoft.education.web.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/api")
@RequiredArgsConstructor
public class CompanyApiController {

    private final CompanyService companyService;

    // 단체 신규등록
    @PostMapping("/company/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void companyInsert(CompanySaveRequest request){
        companyService.companyInsert(request);
    }

    // 단체 목록조회
    @GetMapping("/company/list")
    public Page<CompanyListResponse> categoryList(String cateType, String keyword, String cateName, @PageableDefault(sort = "companySeq", direction = Sort.Direction.DESC) Pageable pageable) {
        return companyService.companyList(cateType, keyword, cateName, pageable);
    }

    // 단체 상세조회
    @GetMapping("/company/detail")
    public CompanyDetailResponse companyDetail(String companySeq, HttpServletRequest request) {
        return companyService.companyDetail(companySeq, request);
    }

    // 단체 수정
    @PostMapping("/company/update")
    public void companyUpdate(CompanyUpdateRequest request) {
        companyService.companyUpdate(request);
    }

    // 단체 삭제
    @PostMapping("/company/delete")
    public void companyDelete(@RequestParam(value="companySeq[]") List<String> companySeq) {
        companyService.companyDelete(companySeq);
    }

}
