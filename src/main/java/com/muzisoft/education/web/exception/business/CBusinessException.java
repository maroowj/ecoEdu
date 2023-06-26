package com.muzisoft.education.web.exception.business;

import com.muzisoft.education.web.api.dto.common.ErrorCode;
import lombok.Getter;

@Getter
public class CBusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public CBusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
