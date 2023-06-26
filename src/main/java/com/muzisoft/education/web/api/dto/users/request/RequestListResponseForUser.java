package com.muzisoft.education.web.api.dto.users.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestListResponseForUser {

    private String requestSeq;
    private boolean requestType;
    private String companyName;
    private String programTitle;
    private String state;
    private String writer;
}
