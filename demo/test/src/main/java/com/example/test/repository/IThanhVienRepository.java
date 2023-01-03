package com.example.test.repository;

import com.example.test.model.so_ho_khau.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IThanhVienRepository extends JpaRepository<ThanhVien, Integer> {
    @Query(value = "select * from thanh_vien  where ho_khau_code = :code", nativeQuery = true)
    List<ThanhVien> searchThanhVien(@Param("code") String code);
}
