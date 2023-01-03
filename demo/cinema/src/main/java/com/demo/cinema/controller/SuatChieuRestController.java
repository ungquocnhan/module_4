package com.demo.cinema.controller;

import com.demo.cinema.model.SuatChieu;
import com.demo.cinema.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/cinemas")
//public class SuatChieuRestController {
//    private final ISuatChieuService suatChieuService;
//
//    public SuatChieuRestController(ISuatChieuService suatChieuService) {
//        this.suatChieuService = suatChieuService;
//    }
//
//    @DeleteMapping("")
//    public ResponseEntity<List<SuatChieu>> deleteSuatChieu(@RequestParam("ids") List<Integer> integers){
//        Optional<List<SuatChieu>> optional = suatChieuService.softDeleteAllIds(integers);
//        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
//    }
//}
