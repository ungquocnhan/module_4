package com.case_study.case_study_module_4.model.user;

import com.case_study.case_study_module_4.model.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> likedRole;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getLikedRole() {
        return likedRole;
    }

    public void setLikedRole(List<Role> likedRole) {
        this.likedRole = likedRole;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
