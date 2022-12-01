package com.exercise.rent_book.service.impl;

import com.exercise.rent_book.model.Book;
import com.exercise.rent_book.model.Order;
import com.exercise.rent_book.repository.IOrderRepository;
import com.exercise.rent_book.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    public int getIdRent(Book book) {
        Order order = new Order();
        int idRent = ThreadLocalRandom.current().nextInt(10000, 99999);
        order.setIdRent(idRent);
        order.setBook(book);
        orderRepository.save(order);
        return idRent;
    }

    @Override
    public Order findByIdRent(int idRent) {
        List<Order> orderList = orderRepository.findAll();
        for (Order order : orderList) {
            if (order.getIdRent() == idRent) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAllOrder();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(order.getIdRent());
    }

}
