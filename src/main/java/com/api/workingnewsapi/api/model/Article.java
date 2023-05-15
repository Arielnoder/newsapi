package com.api.workingnewsapi.api.model;


import jakarta.persistence.*;


public class Article {


    private String Id;

    private String title;

    private String category;

    private String image;

    private String description;

    private String url;

    public Article(String id, String title, String category, String image, String description, String url) {
        Id = id;
        this.title = title;
        this.category = category;
        this.image = image;
        this.description = description;
        this.url = url;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
