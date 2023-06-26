package com.muzisoft.education.web.api.dto.users;

import com.muzisoft.education.domain.company.CompanyEntity;
import com.muzisoft.education.web.api.dto.admin.program.ProgramDetailResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserCompanyDetailResponse {
    private String companySeq;
    private String name;
    private String script;
    private String area;
    private String addressDetail;
    private String tel;
    private Boolean type;
    private String startDate;
    private String homeUrl;
    private String cafeUrl;
    private String email;
    private String imgUrl;
    private String startNo;
    private List<Map<String, Object>> programInfoList;

    public UserCompanyDetailResponse(CompanyEntity company, String imgUrl, List<Map<String, Object>> programInfoList) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        this.companySeq = company.getCompanySeq();
        this.name = company.getName();
        this.script = company.getScript();
        this.area = company.getCategory().getCateName();
        this.addressDetail = company.getAddressDetail();
        this.tel = company.getTel();
        this.type = company.isType();
        this.startDate = company.getStartDate();
        this.homeUrl = company.getHomeUrl();
        this.cafeUrl = company.getCafeUrl();
        this.email = company.getEmail();
        this.imgUrl = imgUrl;
        this.startNo = company.getCreateNo();
        this.programInfoList = programInfoList;
    }
}
