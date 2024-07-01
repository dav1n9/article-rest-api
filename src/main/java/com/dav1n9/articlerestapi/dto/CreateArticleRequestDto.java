package com.dav1n9.articlerestapi.dto;

import com.dav1n9.articlerestapi.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateArticleRequestDto {
    private String title;
    private String username;
    private String password;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .username(username)
                .password(password)
                .content(content)
                .build();
    }
}
