package com.muzisoft.education.web.api.user;

import com.muzisoft.education.web.api.dto.admin.category.CategoryListResponse;
import com.muzisoft.education.web.api.dto.admin.company.CompanyDetailResponse;
import com.muzisoft.education.web.api.dto.users.category.CategoryUserSaveRequest;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user/api")
@RequiredArgsConstructor
public class CategoryUserApiController {

    private final CategoryService categoryService;
    private final ProgramService programService;
    private final CompanyService companyService;

    // 인덱스용 카테고리 목록
    @GetMapping("/category/list")
    public IndexCategoryListResponse categoryListForIndex(HttpServletRequest httpServletRequest) {
        return categoryService.indexCategoryList(httpServletRequest);
    }
}
