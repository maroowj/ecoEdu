package com.muzisoft.education.web.api.dto.admin.program;

import com.muzisoft.education.domain.file.EFileManager;
import com.muzisoft.education.domain.program.ProgramEntity;
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
public class ProgramDetailResponse {

    private String programSeq;
    private String title;
    private String companyName;
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
    private String companySeq;
    private String imgUrl1;
    private String imgUrl2;

    public ProgramDetailResponse(ProgramEntity program, String imgUrl1, String imgUrl2) {
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
        this.companySeq = program.getCompany().getCompanySeq();
        this.imgUrl1 = imgUrl1;
        this.imgUrl2 = imgUrl2;
    }
}
