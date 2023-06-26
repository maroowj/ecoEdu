package com.muzisoft.education.web.api.dto.admin.company;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CompanyListResponse {

    private int rowNum;
    private String companySeq;
    private String name;
    private String area;
    private String addressDetail;
    private String tel;
    private Boolean type;
    private String startDate;
    private String homeUrl;
    private String cafeUrl;
    private String email;
}
