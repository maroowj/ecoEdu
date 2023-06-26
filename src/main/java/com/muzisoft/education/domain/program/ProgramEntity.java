package com.muzisoft.education.domain.program;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muzisoft.education.domain.base.BaseTimeEntity;
import com.muzisoft.education.domain.category.CategoryEntity;
import com.muzisoft.education.domain.company.CompanyEntity;
import com.muzisoft.education.domain.file.EFileManager;
import com.muzisoft.education.utils.manager.SeqManager;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "program")
@DynamicInsert
@DynamicUpdate
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Entity
public class ProgramEntity extends BaseTimeEntity {

    // strategy 수정 후 사용
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_manager_program")
    @GenericGenerator(name = "seq_manager_program", strategy = "com.muzisoft.education.utils.manager.SeqManager", parameters = {
            @org.hibernate.annotations.Parameter(name = SeqManager.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_USER_SEQ_PARAMETER, value = "prog_"),
            @org.hibernate.annotations.Parameter(name = SeqManager.NUMBER_FORMAT_PARAMETER, value = "%010d"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_COLUMN_PARAM, value = "seq")
    })
    @Column(nullable = false, updatable = false, length = 15)
    @Id
    private String programSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companySeq")
    private CompanyEntity company;

    @Column(nullable = false, length = 200)
    private String target;

    @Column(nullable = false, length = 200)
    private String theme;

    @Column(nullable = false, length = 200)
    private String type;

    @Column(nullable = false, unique = true, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String script;

    @Column(nullable = false, length = 255)
    private String schedule;

    @Column(nullable = false, length = 255)
    private String eduTime;

    @Column(nullable = false, length = 255)
    private String oneTime;

    @Column(length = 200)
    private String area;

    @Column(length = 255)
    private String method;

    @Column(length = 255)
    private String memberCount;

    // 1: 무료 / 0: 유료
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean costType;

    @Column(length = 200)
    private String cost;

    // 1: 직접입력 / 0: 단체연락처
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean telType;

    @Column(length = 100)
    private String tel;

    @Column(length = 200)
    private String etc1;

    @Column(length = 200)
    private String etc2;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "img1")
    private EFileManager img1;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "img2")
    private EFileManager img2;

    // 1: 삭제 / 0: 미삭제
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean withdrawal;

    @Builder
    public ProgramEntity(CompanyEntity company, String target, String theme, String type, String title, String script, String schedule,
                         String eduTime, String oneTime, String area, String method, String memberCount, boolean costType, String cost,
                         boolean telType, String tel, String etc1, String etc2, EFileManager img1, EFileManager img2, boolean withdrawal) {
        this.company = company;
        this.target = target;
        this.theme = theme;
        this.type = type;
        this.title = title;
        this.script = script;
        this.schedule = schedule;
        this.eduTime = eduTime;
        this.oneTime = oneTime;
        this.area = area;
        this.method = method;
        this.memberCount = memberCount;
        this.costType = costType;
        this.cost = cost;
        this.telType = telType;
        this.tel = tel;
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.img1 = img1;
        this.img2 = img2;
        this.withdrawal = withdrawal;
    }

    public void deleteProgram() {
        this.withdrawal = true;
    }
    public void updateTitle(String title) {
        this.title = title;
    }
    public void updateScript(String script) {
        this.script = script;
    }
    public void updateCompany(CompanyEntity company) {
        this.company = company;
    }
    public void updateTarget(String target) {
        this.target = target;
    }
    public void updateTheme(String theme) {
        this.theme = theme;
    }
    public void updateType(String type) {
        this.type = type;
    }
    public void updateEndTime(String eduTime) {
        this.eduTime = eduTime;
    }
    public void updateOneTime(String oneTime) {
        this.oneTime = oneTime;
    }
    public void updateMemberCount(String memberCount) {
        this.memberCount = memberCount;
    }
    public void updateSchedule(String schedule) {
        this.schedule = schedule;
    }
    public void updateMethod(String method) {
        this.method = method;
    }
    public void updateCost(String cost) {this.cost = cost;}
    public void updateCostType(boolean costType) {
        this.costType = costType;
    }
    public void updateTel(String tel) {
        this.tel = tel;
    }
    public void updateTelType(boolean telType) {
        this.telType = telType;
    }
    public void setImg1(EFileManager img1) { this.img1 = img1; }
    public void setImg2(EFileManager img2) { this.img2 = img2; }
    public void updateArea(String area) {
        this.area = area;
    }
}
