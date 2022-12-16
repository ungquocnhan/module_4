package com.demo.cinema.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TenPhim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "tenPhim")
    private List<SuatChieu> suatChieuList;

    public TenPhim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SuatChieu> getSuatChieuList() {
        return suatChieuList;
    }

    public void setSuatChieuList(List<SuatChieu> suatChieuList) {
        this.suatChieuList = suatChieuList;
    }
}
