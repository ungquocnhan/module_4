package com.exercise.rent_book.repository;

import com.exercise.rent_book.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where id_rent != 0", nativeQuery = true)
    List<Order> findAllOrder();

    @Transactional
    @Modifying
    @Query(value = "delete from orders where id_rent = :id", nativeQuery = true)
    void deleteOrder(@Param("id") int idRent);
}
