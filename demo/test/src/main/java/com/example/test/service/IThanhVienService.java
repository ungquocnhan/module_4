package com.example.test.service;

import com.example.test.model.so_ho_khau.ThanhVien;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IThanhVienService {
    List<ThanhVien> findAll();

    List<ThanhVien> searchThanhVien(String code);

}
