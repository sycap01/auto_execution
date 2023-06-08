package com.ifinfo.api.infra.support.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorInfo {

    ERROR_0001("0001", "필수 입력 파라미터가 누락되었습니다.", HttpStatus.BAD_REQUEST),
    ERROR_0002("0002", "유효하지 않은 거래입니다.", HttpStatus.BAD_REQUEST),
    ERROR_9999("9999", "시스템 에러가 발생하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    ErrorInfo(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    private String code;
    private String message;
    private HttpStatus httpStatus;
}
