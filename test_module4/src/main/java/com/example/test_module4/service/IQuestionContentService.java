package com.example.test_module4.service;

import com.example.test_module4.model.QuestionContent;
import com.example.test_module4.view.QuestionContentView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IQuestionContentService {
    Page<QuestionContentView> search(String title, String questionType, Pageable pageable);

    void save(QuestionContent questionContent);

    void remove(int id);
}
