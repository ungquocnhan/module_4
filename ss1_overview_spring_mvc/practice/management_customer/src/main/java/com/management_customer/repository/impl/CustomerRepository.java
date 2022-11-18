package com.management_customer.repository.impl;

import com.management_customer.model.Customer;
import com.management_customer.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customers;
    private static long autoIncreaseId = 0;
    static {
        customers = asList(
                new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"),
                new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"),
                new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"),
                new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"),
                new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang")
        );
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }
}
