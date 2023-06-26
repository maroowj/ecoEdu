package com.muzisoft.education.web.api.dto.users.category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryUserListResponse {

    private String companySeq;
    private String name;
    private String address;
    private String addressDetail;
    private String tel;
    private Boolean companyType;
    private Date startDate;
    private String homeUrl;
    private String cafeUrl;
    
    private String programSeq;
    private String title;
    private String companyName;
    private String area;
    private String target;
    private String theme;
    private String type;
    
    
}
