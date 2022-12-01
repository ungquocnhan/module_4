package com.exercise.rent_book.service;

import com.exercise.rent_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAllByNameContaining(String search, Pageable pageable);

    void rentBook(int id);

    void payBook(int id);

    Optional<Book> findById(int id);
}
