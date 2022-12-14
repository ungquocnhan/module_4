package com.test.test.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity

@SQLDelete(sql = "UPDATE customer set flag = false where id = ?")
@Where(clause = "1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @Column(columnDefinition = "date")
    private String birthday;
    @Column(columnDefinition = "bit")
    private boolean gender;
    @Column(unique = true, columnDefinition = "varchar(45)")
    private String idCard;
    @Column(unique = true, columnDefinition = "varchar(45)")
    private String phoneNumber;
    @Column(unique = true, columnDefinition = "varchar(45)")
    private String email;
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @Column(columnDefinition = "bit")
    private boolean flag = true;
    @ManyToOne
    private CustomerType customerType;


    public Customer() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
