package com.example.add_ajax_to_blog.service.impl;

import com.example.add_ajax_to_blog.model.Category;
import com.example.add_ajax_to_blog.repository.ICategoryRepository;
import com.example.add_ajax_to_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Category> findAllCategoryFlag(Pageable pageable) {
        return categoryRepository.findAllCategoryFlag(pageable);
    }

    @Override
    public void updateFlag(int id) {
        categoryRepository.updateFlag(id);
    }
}
