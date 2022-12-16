package com.demo.cinema.service.impl;

import com.demo.cinema.model.TenPhim;
import com.demo.cinema.repository.ITenPhimRepository;
import com.demo.cinema.service.ITenPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenPhimService implements ITenPhimService {
    @Autowired
    private ITenPhimRepository tenPhimRepository;

    @Override
    public List<TenPhim> findAll() {
        return tenPhimRepository.findAll();
    }
}
