package com.muzisoft.education.web.api.dto.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    /**
     * COMMON
     */
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST.value(), "CMM-001", "잘못된 입력입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), "CMM-002", "Method Not Allowed"),
    ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "CMM-003", "Entity Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "CMM-004", "Server Error"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST.value(), "CMM-005", "Invalid Type Value"),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN.value(), "CMM-006", "접근이 거부되었습니다."),
    JSON_WRITE_ERROR(HttpStatus.UNAUTHORIZED.value(), "CMM-007", "JSON content that are not pure I/O problems"),

    /**
     * BUSINESS
     * MZS-1xxx
     */
    LOGIN_FAIL(HttpStatus.BAD_REQUEST.value(), "MZS-1000", "존재하지 않는 계정이거나, 잘못된 비밀번호입니다."),
    ALREADY_SIGNEDUP(HttpStatus.BAD_REQUEST.value(), "MZS-1001", "이미 가입한 사용자입니다."),
    USER_NOT_AUTHENTICATION(HttpStatus.UNAUTHORIZED.value(), "MZS-1002", "인증된 사용자가 아닙니다."),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "MZS-1003", "사용자가 존재하지 않습니다."),
    COMPANY_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "MZS-1004", "단체가 존재하지 않습니다."),
    PROGRAM_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "MZS-1005", "프로그램이 존재하지 않습니다."),
    CATEGORY_NOT_FOUNT(HttpStatus.BAD_REQUEST.value(), "MZS-1006", "카테고리가 존재하지 않습니다."),
    /**
     * SOCIAL
     * MZS-2xxx
     */
    SOCIAL_COMMUNICATION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "MZS-2000", "소셜 인증 과정 중 오류가 발생했습니다."),
    SOCIAL_AGREEMENT_ERROR(HttpStatus.BAD_REQUEST.value(), "MZS-2001", "필수동의 항목에 대해 동의가 필요합니다."),
    INVALID_SOCIAL_TYPE(HttpStatus.BAD_REQUEST.value(), "MZS-2002", "알 수 없는 소셜 타입입니다."),
    SOCIAL_TOKEN_VALID_FAILED(HttpStatus.UNAUTHORIZED.value(), "MZS-2003", "소셜 액세스 토큰 검증에 실패했습니다."),

    /**
     * SECURITY
     * MZS-3xxx
     */
    ACCESS_TOKEN_ERROR(HttpStatus.UNAUTHORIZED.value(), "MZS-3000", "액세스 토큰이 만료되거나 잘못된 값입니다."),
    REFRESH_TOKEN_ERROR(HttpStatus.UNAUTHORIZED.value(), "MZS-3001", "리프레시 토큰이 만료되거나 잘못된 값입니다."),
    TOKEN_PARSE_ERROR(HttpStatus.UNAUTHORIZED.value(), "MZS-3002", "해석할 수 없는 토큰입니다."),

    /**
     * SECURITY
     * MZS-4xxx
     */
    FILE_CONVERT_FAILED(HttpStatus.BAD_REQUEST.value(), "MZS-4000", "파일을 변환할 수 없습니다."),
    INVALID_FILE_FORMAT(HttpStatus.BAD_REQUEST.value(), "MZS-4001", "잘못된 형식의 파일입니다."),
    CLOUD_COMMUNICATION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "MZS-4002", "파일 업로드 중 오류가 발생했습니다."),
            ;

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}