package com.api.workingnewsapi.api.services;
import com.api.workingnewsapi.api.model.Article;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class articleService {
    List<Article> articles = new ArrayList<>();

    public articleService() {
        org.jsoup.nodes.Document doc = null;
        try {
            doc = Jsoup.connect("https://www.mako.co.il/news-dailynews?partner=NewsNavBar").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        org.jsoup.select.Elements articleElements = doc.select("li.regularitemsmall:nth-of-type(n+2) a");
        Article article = null;
        for (org.jsoup.nodes.Element articleElement : articleElements) {
            String articleId = articleElement.attr("href").split("/")[articleElement.attr("href").split("/").length - 1];
            org.jsoup.nodes.Document articleDoc = null;
            try {
                articleDoc = Jsoup.connect("https://www.mako.co.il/" + articleElement.attr("href")).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String title = articleDoc.select("h1").text();
            String category = articleDoc.select(".here span").text();
            String image = articleDoc.select(".article-header figure img").attr("src");
            String description = articleDoc.select("h2").text();
            String url = ("https://www.mako.co.il/" + articleElement.attr("href"));
            article = new Article(articleId, title, category, image, description, url);
            articles.add(article);
        }


    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Article getArticleById(String id) {
        for (Article article : articles) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    public Article getArticle() {
        return articles.get(0);
    }


    public List<Article> getArticlesByCategory(String category) {
        List<Article> articlesByCategory = new ArrayList<>();
        for (Article article : articles) {
            if (article.getCategory().equals(category)) {
                articlesByCategory.add(article);
            }
        }
        return articlesByCategory;
    }



    public Article getArticleByTitle(String title) {
        for (Article article : articles) {
            if (article.getTitle().equals(title)) {
                return article;
            }
        }

        return null;


    }
}
