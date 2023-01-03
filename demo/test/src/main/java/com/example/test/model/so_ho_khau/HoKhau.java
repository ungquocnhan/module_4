package com.example.test.model.so_ho_khau;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Where(clause = "flag = true")
public class HoKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code;
    private String name;
    private int amount;
    private String dateStart;
    private String address;
    @OneToMany(mappedBy = "hoKhau")
    @JsonBackReference
    private List<ThanhVien> thanhVienList;
    private boolean flag = true;

    public HoKhau() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ThanhVien> getThanhVienList() {
        return thanhVienList;
    }

    public void setThanhVienList(List<ThanhVien> thanhVienList) {
        this.thanhVienList = thanhVienList;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
