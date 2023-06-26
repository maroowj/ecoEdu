package com.muzisoft.education.domain.categoryInfo;

import com.muzisoft.education.web.api.dto.admin.category.CategoryListResponse;
import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoListRequest;
import com.muzisoft.education.web.api.dto.users.categoryInfo.CategoryInfoProgramResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryInfoQueryRepository {

    Page<CategoryInfoProgramResponse> userSearchResultList(CategoryInfoListRequest request, Pageable pageable);
}
