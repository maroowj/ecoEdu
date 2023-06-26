package com.muzisoft.education.domain.company;

import com.muzisoft.education.web.api.dto.admin.company.CompanyDetailResponse;
import com.muzisoft.education.web.api.dto.admin.company.CompanyListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyQueryRepository {

    Page<CompanyListResponse> companyList(String cateSeq, String keyword, String CateName, Pageable pageable);

    CompanyDetailResponse companyDetail(String companySeq);
}
