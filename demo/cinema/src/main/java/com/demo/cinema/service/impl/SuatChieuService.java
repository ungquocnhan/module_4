package com.demo.cinema.service.impl;

import com.demo.cinema.dto.SuatChieuView;
import com.demo.cinema.model.SuatChieu;
import com.demo.cinema.repository.ISuatChieuRepository;
import com.demo.cinema.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

//    @Override
//    public Optional<List<SuatChieu>> softDeleteAllIds(List<Integer> integers) {
//        return suatChieuRepository.softDeleteAllIds(integers);
//    }

    @Override
    public Page<SuatChieu> findAll(Pageable pageable) {
        return suatChieuRepository.findAll(pageable);
    }

    @Override
    public Page<SuatChieuView> search(String ngayChieu, String tenPhim, String code, Pageable pageable) {
        return suatChieuRepository.search(ngayChieu, tenPhim, code, pageable);
    }
}
