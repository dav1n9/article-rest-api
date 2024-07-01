package com.dav1n9.articlerestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateArticleRequestDto {
    private String title;
    private String username;
    private String password;
    private String content;
}
