package com.muzisoft.education.domain.request;


import com.muzisoft.education.domain.base.BaseTimeEntity;
import com.muzisoft.education.domain.company.CompanyEntity;
import com.muzisoft.education.domain.program.ProgramEntity;
import com.muzisoft.education.utils.manager.SeqManager;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "request")
@DynamicInsert
@DynamicUpdate
@Entity
public class RequestEntity extends BaseTimeEntity {

    // strategy 수정 후 사용
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_manager_request")
    @GenericGenerator(name = "seq_manager_request", strategy = "com.muzisoft.education.utils.manager.SeqManager", parameters = {
            @org.hibernate.annotations.Parameter(name = SeqManager.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_USER_SEQ_PARAMETER, value = "reqt_"),
            @org.hibernate.annotations.Parameter(name = SeqManager.NUMBER_FORMAT_PARAMETER, value = "%010d"),
            @org.hibernate.annotations.Parameter(name = SeqManager.VALUE_COLUMN_PARAM, value = "seq")
    })
    @Column(nullable = false, updatable = false, length = 15)
    @Id
    private String requestSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companySeq")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programSeq")
    private ProgramEntity program;

    // 1: 단체 수정 / 0: 프로그램 수정
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean requestType;

    @Column(columnDefinition = "TEXT")
    private String request;

    @Column(columnDefinition = "TEXT")
    private String response;

    @Column(length = 20)
    private String writer;

    @Column(length = 20)
    private String grade;

    @Column(length = 20)
    private String phone;

    @Column(length = 200)
    private String email;

    @Column(length = 200)
    private String password;

    @Column(length = 200)
    private String state;

    @Column(length = 200)
    private String impossible;

    @Column(length = 200)
    private String detail;

    @Column(length = 200)
    private String requestUrl;

    // 1: 삭제 / 0: 미삭제
    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean withdrawal;

    @Builder
    public RequestEntity(CompanyEntity company, ProgramEntity program, boolean requestType, String request, String response, String writer,
                         String grade, String phone, String detail, String email, String password, String state, String impossible, String requestUrl, boolean withdrawal) {
        this.company = company;
        this.program = program;
        this.requestType = requestType;
        this.request = request;
        this.response = response;
        this.writer = writer;
        this.grade = grade;
        this.detail = detail;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.state = state;
        this.impossible = impossible;
        this.requestUrl = requestUrl;
        this.withdrawal = withdrawal;

    }

    public void deleteRequest() { this.withdrawal = true; }

    public void updateResponse(String response) { this.response = response; }

    public void updateState(String state) { this.state = state; }

    public void updateImpossible(String impossible) { this.impossible = impossible; }

    public void updateDetail(String detail) { this.detail = detail; }



}
