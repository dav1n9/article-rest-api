package com.dav1n9.articlerestapi.dto;

import com.dav1n9.articlerestapi.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ArticleResponseDto {

    private final Long id;
    private final String title;
    private final String username;
    private final String content;
    private final LocalDateTime createdAt;

    public ArticleResponseDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.username = article.getUsername();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }
}
