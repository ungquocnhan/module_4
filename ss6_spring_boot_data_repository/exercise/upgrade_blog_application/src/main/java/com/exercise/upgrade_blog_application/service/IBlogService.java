package com.exercise.upgrade_blog_application.service;

import com.exercise.upgrade_blog_application.model.Blog;
import com.exercise.upgrade_blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String name);

    Page<Blog> searchAuthorOrContentOrTitle(String name, Pageable pageable);

    void updateFlag(int id);

    Iterable<Blog> findAllByCategory(Category category);
}
