package com.dav1n9.articlerestapi.exception;

import com.dav1n9.articlerestapi.constants.ErrorCode;
import lombok.Getter;

@Getter
public class PasswordMismatchException extends RuntimeException{
    private final ErrorCode errorCode;

    public PasswordMismatchException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
