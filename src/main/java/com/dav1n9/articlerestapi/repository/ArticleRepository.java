package com.dav1n9.articlerestapi.repository;

import com.dav1n9.articlerestapi.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
