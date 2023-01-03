package com.demo.cinema.dto;

import com.demo.cinema.model.TenPhim;

public interface SuatChieuView {
    int getId();

    String getTenSuatChieu();

    String getNgayChieu();

    int getAmount();

    String getTenPhim();

    String getCode();
}
