package com.muzisoft.education.web.api.dto.users.categoryInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryInfoCompanyResponse {

    private String companySeq;
    private String name;
    private String address;
    private String addressDetail;
    private String tel;
    private Boolean companyType;
    private Date startDate;
    private String homeUrl;
    private String cafeUrl;

}
