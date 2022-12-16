package com.demo.cinema.service.impl;

import com.demo.cinema.model.SuatChieu;
import com.demo.cinema.repository.ISuatChieuRepository;
import com.demo.cinema.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuatChieuService implements ISuatChieuService {
    @Autowired
    private ISuatChieuRepository suatChieuRepository;


    @Override
    public List<SuatChieu> showList() {
        return suatChieuRepository.findAll();
    }

    @Override
    public Optional<SuatChieu> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(SuatChieu suatChieu) {
        suatChieuRepository.save(suatChieu);
    }

    @Override
    public void remove(int id) {
        suatChieuRepository.deleteById(id);
    }
}
