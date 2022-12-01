package com.exercise.rent_book.service;

import com.exercise.rent_book.model.Book;
import com.exercise.rent_book.model.Order;

import java.util.List;

public interface IOrderService {

    int getIdRent(Book book);

    Order findByIdRent(int idRent);

    List<Order> findAllOrder();

    void deleteOrder(Order order);

}
