package com.muzisoft.education.web.api.dto.admin.program;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProgramSaveRequest {

    private MultipartFile img1;
    private MultipartFile img2;

    private String title;
    private String script;
    private String companySeq;
    private String target;
    private String theme;
    private String type;
    private String eduTime;
    private String oneTime;
    private String memberCount;
    private String schedule;
    private String method;
    private String cost;
    private int costType;
    private String tel;
    private int telType;
    private String area;
}
