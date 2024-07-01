package com.dav1n9.articlerestapi.exception;

import com.dav1n9.articlerestapi.constants.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
