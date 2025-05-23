package com.example.hwk6;

public class NewsItem {
    private String title;
    private String description;
    private String url;

    public NewsItem(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
