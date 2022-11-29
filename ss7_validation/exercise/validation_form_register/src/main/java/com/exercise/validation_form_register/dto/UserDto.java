package com.exercise.validation_form_register.dto;

import javax.validation.constraints.*;

public class UserDto {
    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 3, max = 45, message = "{Size}")
    private String firstName;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 4, max = 45, message = "{Size}")
    private String lastName;

    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "(090|093)[0-9]{7}", message = "{Phone}")
    private String phoneNumber;

    @Min(value = 18, message = "{Age}")
    private int age;

    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)",message = "{Email}")
    private String email;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
