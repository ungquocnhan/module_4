package com.demo.cinema.dto;

import com.demo.cinema.model.TenPhim;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

public class SuatChieuDto implements Validator {
    private int id;
    @NotBlank(message = "Khong duoc de trong")
    @Pattern(regexp = "[0-9]{4}", message = "Chua 4 so")
//    @UniqueCode
    private String code;
    private String tenSuatChieu;
    private String ngayChieu;
    private int amount;
    private TenPhim tenPhim;

    public SuatChieuDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSuatChieu() {
        return tenSuatChieu;
    }

    public void setTenSuatChieu(String tenSuatChieu) {
        this.tenSuatChieu = tenSuatChieu;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TenPhim getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(TenPhim tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SuatChieuDto suatChieuDto = (SuatChieuDto) target;
        String ngayChieu = suatChieuDto.getNgayChieu();
        LocalDate localDate = LocalDate.parse(ngayChieu);
        LocalDate now = LocalDate.now();
        boolean isAfter = localDate.isAfter(now);
        if(!isAfter){
            errors.rejectValue("ngayChieu", "ngayChieu", "Phai sau ngay hien tai");
        }
    }
}
