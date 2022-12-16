package com.demo.cinema.repository;

import com.demo.cinema.model.TenPhim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITenPhimRepository extends JpaRepository<TenPhim, Integer> {
}
