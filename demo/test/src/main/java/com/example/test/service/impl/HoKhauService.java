package com.example.test.service.impl;

import com.example.test.model.so_ho_khau.HoKhau;
import com.example.test.repository.IHoKhauRepository;
import com.example.test.service.IHoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoKhauService implements IHoKhauService {
    @Autowired
    private IHoKhauRepository hoKhauRepository;

    @Override
    public List<HoKhau> findAll() {
        return hoKhauRepository.findAll();
    }
}
