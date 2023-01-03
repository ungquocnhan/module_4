package com.example.test_module4.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "questionType")
    private List<QuestionContent> questionContentList;

    public QuestionType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionContent> getQuestionContentList() {
        return questionContentList;
    }

    public void setQuestionContentList(List<QuestionContent> questionContentList) {
        this.questionContentList = questionContentList;
    }
}
