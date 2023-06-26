package com.muzisoft.education.web.api.dto.admin.program;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProgramListResponse {

    private int rowNum;
    private String programSeq;
    private String title;
    private String companyName;
    private String area;
    private String target;
    private String theme;
    private String type;

}
