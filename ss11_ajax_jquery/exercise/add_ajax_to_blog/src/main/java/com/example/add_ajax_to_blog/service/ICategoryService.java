package com.example.add_ajax_to_blog.service;

import com.example.add_ajax_to_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category> {
    Page<Category> findAllCategoryFlag(Pageable pageable);

    void updateFlag(int id);

}
