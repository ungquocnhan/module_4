package com.example.test.repository;

import com.example.test.model.so_ho_khau.HoKhau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHoKhauRepository extends JpaRepository<HoKhau, String> {
}
