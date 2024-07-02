package com.dav1n9.articlerestapi.domain;

import com.dav1n9.articlerestapi.dto.UpdateArticleRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Article(String title, String username, String password, String content) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.content = content;
    }

    public void update(UpdateArticleRequestDto request) {
        if (request.getTitle() != null)
            this.title = request.getTitle();
        if (request.getUsername() != null)
            this.username = request.getUsername();
        if (request.getContent() != null)
            this.content = request.getContent();
    }
}
