package com.dav1n9.articlerestapi.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404,"ARTICLE-ERR-404","Article Not Found"),
    PASSWORD_MISMATCH(400, "PASSWORD-ERR-400", "Password is not correct.")
    ;

    private final int status;
    private final String errorCode;
    private final String message;
}
