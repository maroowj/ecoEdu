package com.muzisoft.education.web.api.dto.admin.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestListRequest {

    private Boolean requestType;
    private String searchType;
    private String keyword;
    private String status;

}
