package com.dav1n9.articlerestapi.service;

import com.dav1n9.articlerestapi.domain.Article;
import com.dav1n9.articlerestapi.dto.CreateArticleRequestDto;
import com.dav1n9.articlerestapi.dto.DeleteArticleRequestDto;
import com.dav1n9.articlerestapi.dto.UpdateArticleRequestDto;
import com.dav1n9.articlerestapi.constants.ErrorCode;
import com.dav1n9.articlerestapi.exception.NotFoundException;
import com.dav1n9.articlerestapi.exception.PasswordMismatchException;
import com.dav1n9.articlerestapi.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(CreateArticleRequestDto request) {
        return articleRepository.save(request.toEntity());
    }

    public Article findById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article update(long id, UpdateArticleRequestDto request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));

        validatePassword(article, request.getPassword());

        article.update(request.getTitle(), request.getUsername(), request.getContent());
        return article;
    }

    public Long delete(long id, DeleteArticleRequestDto request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));

        validatePassword(article, request.getPassword());

        articleRepository.deleteById(id);
        return id;
    }

    private void validatePassword(Article article, String password) {
        if (!article.getPassword().equals(password)) {
            throw new PasswordMismatchException(ErrorCode.PASSWORD_MISMATCH);
        }
    }
}
