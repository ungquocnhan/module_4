package com.example.build_blog.repository;

import com.example.build_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String author,String content,String title);
}
