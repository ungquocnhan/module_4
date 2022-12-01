package com.exercise.rent_book.service.impl;

import com.exercise.rent_book.model.Book;
import com.exercise.rent_book.repository.IBookRepository;
import com.exercise.rent_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAllByNameContaining(String search, Pageable pageable) {
        return bookRepository.findAllByNameContaining(search, pageable);
    }

    @Override
    public void rentBook(int id) {
        bookRepository.rentBook(id);
    }

    @Override
    public void payBook(int id) {
        bookRepository.payBook(id);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }
}
