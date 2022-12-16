package com.demo.cinema.repository;

import com.demo.cinema.model.SuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISuatChieuRepository extends JpaRepository<SuatChieu, Integer> {
//    List<SuatChieu> findAll();
}
