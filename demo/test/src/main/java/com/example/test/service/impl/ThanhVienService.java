package com.example.test.service.impl;

import com.example.test.model.so_ho_khau.ThanhVien;
import com.example.test.repository.IThanhVienRepository;
import com.example.test.service.IThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThanhVienService implements IThanhVienService {
    @Autowired
    private IThanhVienRepository thanhVienRepository;
    @Override
    public List<ThanhVien> findAll() {
        return thanhVienRepository.findAll();
    }

    @Override
    public List<ThanhVien> searchThanhVien(String code) {
        return thanhVienRepository.searchThanhVien(code);
    }
}
