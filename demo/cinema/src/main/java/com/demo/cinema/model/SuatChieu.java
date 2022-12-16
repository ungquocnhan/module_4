package com.demo.cinema.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "flag = true")
@SQLDelete(sql = "update suat_chieu set flag = false where id = ?")
public class SuatChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String code;
    private String tenSuatChieu;
    private String ngayChieu;
    private int amount;
    @Column(columnDefinition = "bit")
    private boolean flag = true;
    @ManyToOne
    private TenPhim tenPhim;

    public SuatChieu() {
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
