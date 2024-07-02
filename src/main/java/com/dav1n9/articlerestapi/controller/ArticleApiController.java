package com.dav1n9.articlerestapi.controller;

import com.dav1n9.articlerestapi.domain.Article;
import com.dav1n9.articlerestapi.dto.CreateArticleRequestDto;
import com.dav1n9.articlerestapi.dto.ArticleResponseDto;
import com.dav1n9.articlerestapi.dto.DeleteArticleRequestDto;
import com.dav1n9.articlerestapi.dto.UpdateArticleRequestDto;
import com.dav1n9.articlerestapi.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponseDto> addArticle(@RequestBody CreateArticleRequestDto request) {
        Article article = articleService.save(request);

        return ResponseEntity.ok()
                .body(new ArticleResponseDto(article));
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponseDto> findArticle(@PathVariable long id) {
        Article article = articleService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponseDto(article));
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticle() {
        List<ArticleResponseDto> articles = articleService.findAll()
                .stream().map(ArticleResponseDto::new).toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponseDto> updateArticle(@PathVariable long id,
                                                            @RequestBody UpdateArticleRequestDto request) {
        Article article = articleService.update(id, request);

        return ResponseEntity.ok()
                .body(new ArticleResponseDto(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Long> deleteArticle(@PathVariable long id,
                                              @RequestBody DeleteArticleRequestDto request) {
        Long deletedId = articleService.delete(id, request);

        return ResponseEntity.ok()
                .body(deletedId);
    }
}
