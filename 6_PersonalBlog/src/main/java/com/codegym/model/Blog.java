package com.codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private int likes;

    private Date date;

    @ManyToOne
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String title, String content, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Blog(Long id, String title, String content, int likes, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.date = date;
    }

    public Blog(Long id, String title, String content, int likes, Date date, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
