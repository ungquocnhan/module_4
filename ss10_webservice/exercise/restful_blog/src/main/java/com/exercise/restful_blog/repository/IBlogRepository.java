package com.exercise.restful_blog.repository;

import com.exercise.restful_blog.model.Blog;
import com.exercise.restful_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String author, String content, String title);

    Iterable<Blog> findAllByCategory(Category category);


    @Query(value = "select * from blog where flag = 1 and (author like CONCAT('%', :author, '%') or content like CONCAT('%', :content, '%') or title like CONCAT('%', :title, '%'))", nativeQuery = true)
    Page<Blog> searchAuthorOrContentOrTitle(@Param("author") String author, @Param("content") String content, @Param("title") String title, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update blog set flag = 0 where id = :id", nativeQuery = true)
    void updateFlag(@Param("id") int id);
}
