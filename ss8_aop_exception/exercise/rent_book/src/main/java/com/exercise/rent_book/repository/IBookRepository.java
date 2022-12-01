package com.exercise.rent_book.repository;

import com.exercise.rent_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByNameContaining(String search, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update book set amount = amount - 1 where id = :id", nativeQuery = true)
    void rentBook(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update book set amount = amount + 1 where id = :id", nativeQuery = true)
    void payBook(@Param("id") int id);
}
