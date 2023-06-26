package com.muzisoft.education.domain.category;

import com.muzisoft.education.web.api.dto.admin.category.CategoryListResponse;
import com.muzisoft.education.web.api.dto.users.category.CategoryUserListResponse;
import com.muzisoft.education.web.api.dto.users.category.CategoryUserSaveRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryQueryRepository {

    Page<CategoryListResponse> categoryList(String cateType, Pageable pageable);

//    Page<CategoryUserListResponse> categoryUserList(CategoryUserSaveRequest request, Pageable pageable);
}
