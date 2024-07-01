package com.dav1n9.articlerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ArticleRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleRestApiApplication.class, args);
    }

}
