package com.exercise.upgrade_blog_application.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    private String author;
    @Column(columnDefinition = "date")
    private String dateStart;
    @Column(columnDefinition = "bit")
    private boolean flag = true;
    @ManyToOne
    private Category category;

    public Blog() {
    }

    public Blog(String title, String content, String author, String dateStart) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateStart = dateStart;
    }

    public Blog(int id, String title, String content, String author, String dateStart, boolean flag, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateStart = dateStart;
        this.flag = flag;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
