package com.exercise.upgrade_blog_application.service;

import com.exercise.upgrade_blog_application.model.Category;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Category> findAllCategoryFlag();

    void updateFlag(int id);

}
