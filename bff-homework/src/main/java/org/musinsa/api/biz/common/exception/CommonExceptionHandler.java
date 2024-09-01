package org.musinsa.api.biz.common.exception;


import org.musinsa.api.biz.common.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleException(Exception ex) {
        String errorMessage = ex.getMessage();

        // BaseResponse 객체를 생성
        BaseResponse<String> errorResponse = new BaseResponse<>(
                errorMessage != null ? errorMessage : "An unexpected error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorMessage = ex.getMessage();

        BaseResponse<String> errorResponse = new BaseResponse<>(
                errorMessage != null ? errorMessage : "An unexpected error occurred",
                HttpStatus.NO_CONTENT.value() // 204 No Content
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }
}
