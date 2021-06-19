package com.demo.model;

public class LessonModel extends AbstractModel<LessonModel>{
    private long id;
    private String categoryCode;
    private String image;
    private String sound;
    private String content;

    public LessonModel() {
    }

    public LessonModel(long id, String categoryCode, String image, String sound, String content) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.image = image;
        this.sound = sound;
        this.content = content;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
