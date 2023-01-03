package com.example.test.model.phong_tro;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypePay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "typePay")
    private List<PhongThue> phongThueList;

    public TypePay() {
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

    public List<PhongThue> getPhongThueList() {
        return phongThueList;
    }

    public void setPhongThueList(List<PhongThue> phongThueList) {
        this.phongThueList = phongThueList;
    }
}
