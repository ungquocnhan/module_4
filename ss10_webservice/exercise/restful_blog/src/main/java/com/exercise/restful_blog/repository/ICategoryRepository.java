package com.exercise.restful_blog.repository;

import com.exercise.restful_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from categories where flag = 1", nativeQuery = true)
    Page<Category> findAllCategoryFlag(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update categories set flag = 0 where id = :id", nativeQuery = true)
    void updateFlag(@Param("id") int id);

}
