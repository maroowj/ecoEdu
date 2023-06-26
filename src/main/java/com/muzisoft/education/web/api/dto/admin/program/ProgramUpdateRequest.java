package com.muzisoft.education.web.api.dto.admin.program;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProgramUpdateRequest {

    private String programSeq;
    private String title;
    private String script;
    private String companySeq;
    private String target;
    private String theme;
    private String type;
    private String area;
    private String eduTime;
    private String oneTime;
    private String memberCount;
    private String schedule;
    private String method;
    private String cost;
    private Integer costType;
    private String tel;
    private Integer telType;
    private MultipartFile img1;
    private MultipartFile img2;

}
