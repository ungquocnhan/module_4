package com.example.test.model.phong_tro;

import javax.persistence.*;

@Entity
public class PhongThue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String numberPhone;
    private String startDate;
    @ManyToOne
    private TypePay typePay;
    private String note;
    @Column(columnDefinition = "bit")
    private boolean flag = true;

    public PhongThue() {
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TypePay getTypePay() {
        return typePay;
    }

    public void setTypePay(TypePay typePay) {
        this.typePay = typePay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
