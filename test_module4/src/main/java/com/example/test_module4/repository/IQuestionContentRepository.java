package com.example.test_module4.repository;

import com.example.test_module4.model.QuestionContent;
import com.example.test_module4.view.QuestionContentView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent, Integer> {
    @Query(value = "select qc.id, qc.date_create as dateCreate, qc.status, qc.title, qt.name as questionType from question_content qc join question_type qt on qc.question_type_id = qt.id where qc.flag = true and qc.title like concat('%',:title,'%') and qt.name like concat('%',:questionType,'%') order by qc.status, qc.date_create desc ",
    countQuery = "select * from (select qc.id, qc.date_create as dateCreate, qc.status, qc.title, qt.name as questionType from question_content qc join question_type qt on qc.question_type_id = qt.id where qc.flag = true and qc.title like concat('%',:title,'%') and qt.name like concat('%',:questionType,'%') order by qc.status, qc.date_create desc) as count_page",
    nativeQuery = true)
    Page<QuestionContentView> search(@Param("title") String title, @Param("questionType") String questionType, Pageable pageable);
}
