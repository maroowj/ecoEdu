package com.muzisoft.education.web.api.user;

import com.muzisoft.education.web.api.dto.admin.company.CompanyDetailResponse;
import com.muzisoft.education.web.api.dto.users.UserCompanyDetailResponse;
import com.muzisoft.education.web.api.dto.users.category.IndexCategoryListResponse;
import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoListRequest;
import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoProgramResponse;
import com.muzisoft.education.web.service.category.CategoryService;
import com.muzisoft.education.web.service.company.CompanyService;
import com.muzisoft.education.web.service.program.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user/api")
@RequiredArgsConstructor
public class ProgramUserApiController {

    private final CategoryService categoryService;
    private final ProgramService programService;
    private final CompanyService companyService;

    // 카테고리별 단체 및 프로그램 리스트 조회
    @GetMapping("/list")
    public Page<CategoryInfoProgramResponse> userSearchResultList(@RequestParam(value="cateName[]") ArrayList<String> cateName, CategoryInfoListRequest request, Pageable pageable, HttpServletRequest httpServletRequest) {
        request.setCateName(cateName);
        return categoryService.userSearchResultList(request, pageable, httpServletRequest);
    }

    //카테고리별 단체 상세 조회
    @GetMapping("/company/detail")
    public UserCompanyDetailResponse companyDetail(String companySeq, HttpServletRequest request) {
        return companyService.userCompanyDetail(companySeq, request);
    }

    // 카테고리별 프로그램 상세 조회
    @GetMapping("/program/detail")
    public Map<String, Object> programDetail(String programSeq, HttpServletRequest request) {
        return programService.userProgramDetail(programSeq, request);
    }

}
