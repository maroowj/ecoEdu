package com.muzisoft.education.web.exception.security;

import com.muzisoft.education.web.api.dto.common.ErrorCode;
import lombok.Getter;

@Getter
public class CSecurityException extends RuntimeException {

    private ErrorCode errorCode;

    public CSecurityException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public static class CAuthenticationEntryPointException extends CSecurityException {

        public CAuthenticationEntryPointException() {
            super(ErrorCode.ACCESS_TOKEN_ERROR);
        }
    }

}
