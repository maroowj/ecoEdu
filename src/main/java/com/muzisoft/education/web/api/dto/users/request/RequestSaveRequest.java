package com.muzisoft.education.web.api.dto.users.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestSaveRequest {

    private String companySeq;
    private String programSeq;
    private int requestType;
    private String writer;
    private String request;
    private String password;
    private String grade;
    private String phone;
    private String email;
    private String impossible;
    private String requestUrl;

}
