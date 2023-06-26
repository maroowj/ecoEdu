package com.muzisoft.education.web.api.admin;

import com.muzisoft.education.domain.category.CategoryEntity;
import com.muzisoft.education.web.api.dto.admin.category.CategoryDetailResponse;
import com.muzisoft.education.web.api.dto.admin.category.CategoryListResponse;
import com.muzisoft.education.web.api.dto.admin.category.CategorySaveRequest;
import com.muzisoft.education.web.api.dto.admin.category.CategoryUpdateRequest;
import com.muzisoft.education.web.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/api")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;

    // admin: 카테고리 신규등록
    @PostMapping("/category/save")
    public void categoryInsert(CategorySaveRequest request) {
        categoryService.categoryInsert(request);
    }

    // admin: 카테고리 목록조회
    @GetMapping("/category/list")
    public Page<CategoryListResponse> categoryList(String cateType, @PageableDefault(sort = "cateSeq", direction = Sort.Direction.DESC) Pageable pageable) {
        return categoryService.categoryList(cateType, pageable);
    }

    // admin: 카테고리 상세조회
    @GetMapping("/category/detail")
    public CategoryDetailResponse categoryDetail(String cateSeq, HttpServletRequest request) {
        return categoryService.categoryDetail(cateSeq, request);
    }

    // admin: 카테고리 수정
    @PostMapping("/category/update")
    public void categoryUpdate(CategoryUpdateRequest request) {
        categoryService.categoryUpdate(request);
    }

    // admin: 카테고리 삭제
    @GetMapping("/category/delete")
    public void categoryDelete(@RequestParam(value="cateSeq[]") List<String> cateSeq) { categoryService.categoryDelete(cateSeq); }

}
