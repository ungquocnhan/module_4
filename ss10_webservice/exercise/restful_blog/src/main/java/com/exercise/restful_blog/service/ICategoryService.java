package com.exercise.restful_blog.service;

import com.exercise.restful_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    Page<Category> findAllCategoryFlag(Pageable pageable);

    void updateFlag(int id);

}
