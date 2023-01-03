package com.example.test_module4.service.impl;

import com.example.test_module4.model.QuestionContent;
import com.example.test_module4.repository.IQuestionContentRepository;
import com.example.test_module4.service.IQuestionContentService;
import com.example.test_module4.view.QuestionContentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private IQuestionContentRepository questionContentRepository;
    @Override
    public Page<QuestionContentView> search(String title, String questionType, Pageable pageable) {
        return questionContentRepository.search(title, questionType, pageable);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void remove(int id) {
        questionContentRepository.deleteById(id);
    }
}
