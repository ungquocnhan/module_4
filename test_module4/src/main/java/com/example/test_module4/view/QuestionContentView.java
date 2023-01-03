package com.example.test_module4.view;

import com.example.test_module4.model.QuestionType;

public interface QuestionContentView {
    int getId();

    String getTitle();

    String getContent();

    String getAnswer();

    String getDateCreate();

    String getStatus();

    String getQuestionType();
}
