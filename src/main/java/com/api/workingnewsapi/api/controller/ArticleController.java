package com.api.workingnewsapi.api.controller;


import com.api.workingnewsapi.api.model.Article;
import com.api.workingnewsapi.api.services.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ArticleController {

    private articleService service;

    @Autowired
    public ArticleController(articleService service) {
        this.service = service;
    }



    @GetMapping("/api/articles")
    public List<Article> getArticles() {
        return service.getAllArticles();
    }

    @GetMapping("/api/article")
    public Article getArticle() {
        return service.getArticle();
    }


    @GetMapping("/api/articles/{id}")
    public Article getArticleById(@PathVariable String id) {
        return service.getArticleById(id);
    }


    @GetMapping("/api/articles/category/{category}")

    public List<Article> getArticlesByCategory(@PathVariable String category) {
        return service.getArticlesByCategory(category);
    }







    @GetMapping("/api/articles/title/{title}")
    public Article getArticleByTittle(@PathVariable String title) {
        return service.getArticleByTitle(title);
    }
















}
