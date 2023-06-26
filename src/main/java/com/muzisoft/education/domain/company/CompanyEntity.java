package com.muzisoft.education.domain.company;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muzisoft.education.domain.base.BaseTimeEntity;
import com.muzisoft.education.domain.category.CategoryEntity;
import com.muzisoft.education.domain.file.EFileManager;
import com.muzisoft.education.domain.program.ProgramEntity;
import com.muzisoft.education.utils.manager.SeqManager;
import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "company")
@DynamicInsert
@DynamicUpdate
@Entity
@ToString
public class CompanyEntity extends BaseTimeEntity {

    // strategy 수정 후 사용
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_manager_company")
    @GenericGenerator(name = "seq_manager_company", strategy = "com.muzisoft.education.utils.manager.SeqManager", parameters = {
            @org.hibernate.annotations.Parameter(name = SeqManager.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_USER_SEQ_PARAMETER, value = "comp_"),
            @org.hibernate.annotations.Parameter(name = SeqManager.NUMBER_FORMAT_PARAMETER, value = "%010d"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_COLUMN_PARAM, value = "seq")
    })
    @Column(nullable = false, updatable = false, length = 15)
    @Id
    private String companySeq;

    @Column(nullable = false, unique = true, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String script;

    @Column(nullable = false, length = 20)
    private String startDate;

    @Column(length = 200)
    private String homeUrl;

    @Column(length = 200)
    private String cafeUrl;

    @Column(nullable = false, length = 200)
    private String createNo;

    @Column(length = 100)
    private String tel;

    @Column(length = 100)
    private String email;

    // 1: 공공기관 / 0: 민간단체
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cateSeq")
//    @JsonIgnore
    private CategoryEntity category;

    @Column(length = 200)
    private String addressDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "img")
    private EFileManager img;

    @Column(length = 200)
    private String etc1;

    @Column(length = 200)
    private String etc2;

    // 1: 삭제 / 0: 미삭제
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean withdrawal;

    @Builder
    public CompanyEntity(CategoryEntity category, String name, String script, String startDate, String homeUrl, String cafeUrl, String email,
                         String createNo, String tel, boolean type, String addressDetail, String etc1, String etc2, boolean withdrawal,
                         EFileManager img) {
        this.name = name;
        this.script = script;
        this.startDate = startDate;
        this.homeUrl = homeUrl;
        this.cafeUrl = cafeUrl;
        this.email = email;
        this.createNo = createNo;
        this.tel = tel;
        this.type = type;
        this.category = category;
        this.addressDetail = addressDetail;
        this.img = img;
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.withdrawal = withdrawal;
    }

    public void deleteCompany() {
        this.withdrawal = true;
    }

    public void updateName(String name) {
        this.name = name;
    }
    public void updateScript(String script) {
        this.script = script;
    }
    public void updateStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void updateCreateNo(String createNo) {
        this.createNo = createNo;
    }
    public void updateType(boolean type) {
        this.type = type;
    }
    public void updateHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }
    public void updateCafeUrl(String cafeUrl) {
        this.cafeUrl = cafeUrl;
    }
    public void updateEmail(String email) {
        this.email = email;
    }
    public void updateTel(String tel) {
        this.tel = tel;
    }
    public void updateArea(CategoryEntity category) {
        this.category = category;
    }
    public void updateAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
    public void setImg(EFileManager img) { this.img = img; }
}
