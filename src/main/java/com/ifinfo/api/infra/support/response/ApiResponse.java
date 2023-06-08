package com.ifinfo.api.infra.support.response;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    private String status;
    private T content;

    public static <T> ApiResponse<T> success(T data) {

        return new ApiResponse<>(SUCCESS, data);
    }

    public static <T> ApiResponse<T> error(T data) {

        return new ApiResponse<>(ERROR, data);
    }

    private ApiResponse(String status, T content) {
        this.status = status;
        this.content = content;
    }
}