package com.muzisoft.education.web.api.dto.admin.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestListResponse {
    private int rowNum;
    private String requestSeq;
    private Boolean requestType;
    private String name;
    private String title;
    private String state;
    private String createDate;
    private String writer;
    private String phone;
}
