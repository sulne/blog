package com.github.sulne.blog.entity;

import java.io.Serializable;

public class TimeLine implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String date;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
