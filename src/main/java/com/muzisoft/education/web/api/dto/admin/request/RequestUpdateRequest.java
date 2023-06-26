package com.muzisoft.education.web.api.dto.admin.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestUpdateRequest {

    private String requestSeq;
    private String state;
    private String response;
    private String impossible;
    private String detail;

}
