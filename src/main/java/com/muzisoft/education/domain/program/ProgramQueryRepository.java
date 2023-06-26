package com.muzisoft.education.domain.program;

import com.muzisoft.education.domain.category.CategoryEntity;
import com.muzisoft.education.web.api.dto.admin.program.ProgramDetailResponse;
import com.muzisoft.education.web.api.dto.admin.program.ProgramListRequest;
import com.muzisoft.education.web.api.dto.admin.program.ProgramListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProgramQueryRepository {
    ProgramDetailResponse programDetail(String programSeq);

    Page<ProgramListResponse> programList(ProgramListRequest request, Pageable pageable);

    List<ProgramEntity> findByCategoryAndWithdrawal(String categorySeq);
}
