package com.muzisoft.education.web.api.dto.admin.program;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProgramListRequest {

    private String companySeq;
    private String searchTheme;
    private String searchType;
    private String searchTarget;
    private String query;

}
