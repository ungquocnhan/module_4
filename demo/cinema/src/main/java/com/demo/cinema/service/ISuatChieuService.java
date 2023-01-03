package com.demo.cinema.service;

import com.demo.cinema.dto.SuatChieuView;
import com.demo.cinema.model.SuatChieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ISuatChieuService {
    List<SuatChieu> showList();

    Optional<SuatChieu> findById(int id);

    void save(SuatChieu suatChieu);

    void remove(int id);

//    Optional<List<SuatChieu>> softDeleteAllIds(List<Integer> integers);

    Page<SuatChieu> findAll(Pageable pageable);

    Page<SuatChieuView> search(String ngayChieu, String tenPhim, String code, Pageable pageable);

}
