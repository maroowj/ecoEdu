package com.muzisoft.education.web.exception.business;

import com.muzisoft.education.web.api.dto.common.ErrorCode;

public class CEntityNotFoundException extends CBusinessException {
    public CEntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static class CUserNotFoundException extends CEntityNotFoundException {
        public CUserNotFoundException() {
            super(ErrorCode.USER_NOT_FOUND);
        }
    }

    public static class CCompanyNotFoundException extends CEntityNotFoundException {
        public CCompanyNotFoundException() {
            super(ErrorCode.COMPANY_NOT_FOUND);
        }
    }

    public static class CProgramNotFoundException extends CEntityNotFoundException {
        public CProgramNotFoundException() {
            super(ErrorCode.PROGRAM_NOT_FOUND);
        }
    }

    public static class CCategoryNotFoundException extends CEntityNotFoundException {
        public CCategoryNotFoundException() {
            super(ErrorCode.CATEGORY_NOT_FOUNT);
        }
    }
}
