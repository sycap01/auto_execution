package com.ifinfo.api.infra.support.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private ErrorInfo errorInfo;

    public ApiException() {
        super();
    }

    public ApiException(ErrorInfo errorInfo, String errorMessage) {
        super(errorMessage);
        this.errorInfo = errorInfo;
    }

}
