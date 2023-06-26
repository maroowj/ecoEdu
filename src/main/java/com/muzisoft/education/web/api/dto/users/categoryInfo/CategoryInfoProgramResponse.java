package com.muzisoft.education.web.api.dto.users.categoryInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryInfoProgramResponse {

    private String programSeq;
    private String companySeq;
    private String title;
    private String companyName;
    private String companyAddress;
    private String companyTel;
    private String homeUrl;
    private String cafeUrl;
    private String email;
    private String area;
    private String target;
    private String theme;
    private String type;
    private String memberCount;
    private String schedule;
    private String script;
    private String programImg;
    private String companyImg;
    private String method;
}
