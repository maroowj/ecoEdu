package com.muzisoft.education.web.api.dto.admin.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestDetailResponse {
    private String requestSeq;
    private String name;
    private String title;
    private String state;
    private String request;
    private Boolean requestType;
    private String writer;
    private String createDate;
    private String grade;
    private String phone;
    private String impossible;
    private String email;
    private String detail;
    private String requestUrl;

}
