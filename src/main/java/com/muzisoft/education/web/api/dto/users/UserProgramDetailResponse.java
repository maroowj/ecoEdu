package com.muzisoft.education.web.api.dto.users;

import com.muzisoft.education.domain.program.ProgramEntity;
import com.muzisoft.education.web.api.dto.admin.company.CompanyDetailResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserProgramDetailResponse {

    private String programSeq;
    private String title;
    private String address;
    private String theme;
    private String target;
    private String type;
    private String script;
    private String cost;
    private boolean costType;
    private String area;
    private String eduTime;
    private String oneTime;
    private String memberCount;
    private String method;
    private String schedule;
    private String tel;
    private boolean telType;
    private String imgUrl1;
    private String imgUrl2;
    private String companySeq;
    private String companyName;
    private String companyScript;
    private String companyImgUrl;

    public UserProgramDetailResponse(ProgramEntity program, String imgUrl1, String imgUrl2, String companyImgUrl) {
        this.programSeq = program.getProgramSeq();
        this.title = program.getTitle();
        this.companyName = program.getCompany().getName();
        this.address = program.getCompany().getAddressDetail();
        this.theme = program.getTheme();
        this.target = program.getTarget();
        this.type = program.getType();
        this.script = program.getScript();
        this.cost = program.getCost();
        this.costType = program.isCostType();
        this.area = program.getArea();
        this.eduTime = program.getEduTime();
        this.oneTime = program.getOneTime();
        this.memberCount = program.getMemberCount();
        this.method = program.getMethod();
        this.schedule = program.getSchedule();
        this.tel = program.getTel();
        this.telType = program.isTelType();
        this.imgUrl1 = imgUrl1;
        this.imgUrl2 = imgUrl2;
        this.companySeq = program.getCompany().getCompanySeq();
        this.companyName = program.getCompany().getName();
        this.companyScript = program.getCompany().getScript();
        this.companyImgUrl = companyImgUrl;
    }
}
