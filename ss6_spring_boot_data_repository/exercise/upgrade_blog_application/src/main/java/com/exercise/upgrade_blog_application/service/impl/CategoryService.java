package com.exercise.upgrade_blog_application.service.impl;

import com.exercise.upgrade_blog_application.model.Category;
import com.exercise.upgrade_blog_application.repository.ICategoryRepository;
import com.exercise.upgrade_blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategoryFlag() {
        return categoryRepository.findAllCategoryFlag();
    }

    @Override
    public void updateFlag(int id) {
        categoryRepository.updateFlag(id);
    }
}
