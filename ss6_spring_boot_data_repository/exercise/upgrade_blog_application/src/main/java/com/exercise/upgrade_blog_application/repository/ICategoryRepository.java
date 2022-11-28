package com.exercise.upgrade_blog_application.repository;

import com.exercise.upgrade_blog_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category where flag = 1", nativeQuery = true)
    List<Category> findAllCategoryFlag();

    @Transactional
    @Modifying
    @Query(value = "update category set flag = 0 where id = :id", nativeQuery = true)
    void updateFlag(@Param("id") int id);

}
