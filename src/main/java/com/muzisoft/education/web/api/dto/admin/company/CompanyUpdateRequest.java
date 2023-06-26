package com.muzisoft.education.web.api.dto.admin.company;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CompanyUpdateRequest {

    private String companySeq;
    private String name;
    private String script;
    private String startDate;
    private String createNo;
    private Integer type;
    private String homeUrl;
    private String cafeUrl;
    private String email;
    private String tel;
    private String area;
    private String addressDetail;
    private MultipartFile img;

}
