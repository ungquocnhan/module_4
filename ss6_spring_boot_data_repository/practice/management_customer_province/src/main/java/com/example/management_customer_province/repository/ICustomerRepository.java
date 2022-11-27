package com.example.management_customer_province.repository;

import com.example.management_customer_province.model.Customer;
import com.example.management_customer_province.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    Iterable<Customer> findAllByProvince(Province province);
}
