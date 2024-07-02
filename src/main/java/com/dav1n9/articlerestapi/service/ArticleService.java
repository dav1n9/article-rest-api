package com.dav1n9.articlerestapi.service;

import com.dav1n9.articlerestapi.domain.Article;
import com.dav1n9.articlerestapi.dto.CreateArticleRequestDto;
import com.dav1n9.articlerestapi.dto.DeleteArticleRequestDto;
import com.dav1n9.articlerestapi.dto.UpdateArticleRequestDto;
import com.dav1n9.articlerestapi.constants.ErrorCode;
import com.dav1n9.articlerestapi.exception.BusinessException;
import com.dav1n9.articlerestapi.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(CreateArticleRequestDto request) {
        return articleRepository.save(request.toEntity());
    }

    public Article findById(long id) {
        return findArticleById(id);
    }

    public List<Article> findAll() {
        return articleRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Article update(long id, UpdateArticleRequestDto request) {
        Article article = findArticleById(id);
        validatePassword(article, request.getPassword());

        article.update(request);
        return article;
    }

    public Long delete(long id, DeleteArticleRequestDto request) {
        Article article = findArticleById(id);
        validatePassword(article, request.getPassword());

        articleRepository.deleteById(id);
        return id;
    }

    private Article findArticleById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND));
    }

    private void validatePassword(Article article, String password) {
        if (!article.getPassword().equals(password)) {
            throw new BusinessException(ErrorCode.PASSWORD_MISMATCH);
        }
    }
}
