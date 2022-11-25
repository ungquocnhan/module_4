package com.example.build_blog.service;

import com.example.build_blog.model.Blog;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog>{
    List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String name);

}
