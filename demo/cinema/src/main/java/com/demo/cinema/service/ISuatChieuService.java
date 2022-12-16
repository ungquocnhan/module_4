package com.demo.cinema.service;

import com.demo.cinema.model.SuatChieu;

import java.util.List;
import java.util.Optional;

public interface ISuatChieuService {
    List<SuatChieu> showList();

    Optional<SuatChieu> findById(int id);

    void save(SuatChieu suatChieu);

    void remove(int id);
}
