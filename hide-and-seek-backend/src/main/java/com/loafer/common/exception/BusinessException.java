package com.loafer.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 自定义异常类
 */
@Getter
public class BusinessException extends RuntimeException {

    private final HttpStatus status;

    public BusinessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

}
