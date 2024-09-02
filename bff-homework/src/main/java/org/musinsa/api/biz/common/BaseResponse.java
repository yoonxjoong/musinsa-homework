package org.musinsa.api.biz.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private T data;

    private String message;

    private int statusCode;

    public BaseResponse() {}

    public BaseResponse(T data, String message, int statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public BaseResponse(String message, int value) {
        this.message = message;
        this.statusCode = value;
    }
}
