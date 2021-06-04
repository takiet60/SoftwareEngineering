package com.demo.model;

public class NewsModel extends AbstractModel<NewsModel>{

    private String title;
    private String thumbnall;
    private String shortDescription;
    private String content;
    private long categoryId;
    private String categoryCode;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getThumbnall() { return thumbnall; }

    public void setThumbnall(String thumbnall) { this.thumbnall = thumbnall; }

    public String getShortDescription() {return shortDescription; }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public long getCategoryId() { return categoryId; }

    public void setCategoryId(long categoryId) { this.categoryId = categoryId; }


}
