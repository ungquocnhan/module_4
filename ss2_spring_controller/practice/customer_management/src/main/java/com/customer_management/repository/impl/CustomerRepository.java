package com.customer_management.repository.impl;

import com.customer_management.model.Customer;
import com.customer_management.repository.ICustomerRepository;
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

    @Override
    public Customer findOne(Long id) {
        for(Customer customer : customers){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer edit(Customer customer) {
        Customer customer1 = findOne(customer.getId());
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());
        return customer;
    }

//    @Override
//    public Customer save(Customer customer) {
//        return customer.getId() == null ? persist(customer) : merge(customer);
//    }
//
//    private Customer persist(Customer customer) {
//        Customer clone = (Customer) customer.clone();
//        clone.setId(autoIncreaseId++);
//        customers.add(clone);
//        return clone;
//    }
//
//    private Customer merge(Customer customer) {
//        Customer origin = findOne(customer.getId());
//        origin.setName(customer.getName());
//        origin.setEmail(customer.getEmail());
//        origin.setAddress(customer.getAddress());
//        return origin;
//    }
}
