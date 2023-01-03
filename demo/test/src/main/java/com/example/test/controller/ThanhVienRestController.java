package com.example.test.controller;

import com.example.test.model.so_ho_khau.ThanhVien;
import com.example.test.service.IThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thanhviens")
public class ThanhVienRestController {
    @Autowired
    private IThanhVienService thanhVienService;

    @GetMapping("")
    public ResponseEntity<List<ThanhVien>> showListThanhVien(@RequestParam("code") String code){
        List<ThanhVien> thanhVienList = thanhVienService.searchThanhVien(code);
        return new ResponseEntity<>(thanhVienList, HttpStatus.OK);
    }
}
