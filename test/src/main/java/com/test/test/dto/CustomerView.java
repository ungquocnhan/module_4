package com.test.test.dto;

import com.test.test.model.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class CustomerView {
    private int id;

    private String name;

    private String birthday;

    private boolean gender;

    private String idCard;

    private String phoneNumber;

    private String email;

    private String address;

    private boolean flag = true;

    private CustomerType customerType;
}
