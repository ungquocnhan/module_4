package com.case_study.case_study_module_4.dto;

import com.case_study.case_study_module_4.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CustomerDto implements Validator {
    private int id;
    @NotBlank
    private String name;
    private String birthday;
    private boolean gender;
    @NotBlank
    @Pattern(regexp = "([0-9]{12})|([0-9]{9})", message = "Incorrect format id card.  Must 9 - 12 numbers")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "(090|091|[(][84]{2}[)][+][90]{2}|[(][84]{2}[)][+][91]{2})[0-9]{7}", message = "Incorrect format phone number. Must 090, 091, (84)+90, (84)+91 + 7 numbers")
    private String phoneNumber;
    @Pattern(regexp = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)", message = "Incorrect format email.")
    private String email;
    @NotBlank
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String name = customerDto.getName();
        String[] nameSplit = name.trim().split(" ");
        String regex = "^[A-ZÂÊÔƯĐ][a-záàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]{1,7}$";
        for (String string : nameSplit) {
            if (!string.matches(regex)) {
                errors.rejectValue("name", "name", "Incorrect Format Name");
            }
        }

        String birthdayVal = customerDto.getBirthday();
        LocalDate dayOfBirth = LocalDate.parse(birthdayVal);
        LocalDate now = LocalDate.now();
        Period checkAge = Period.between(dayOfBirth, now);
        if(checkAge.getYears() < 18 | checkAge.getYears() > 100){
            errors.rejectValue("birthday", "birthday", "You are not enough age (< 18) or too old (> 100) to register service");
        }
    }
}
