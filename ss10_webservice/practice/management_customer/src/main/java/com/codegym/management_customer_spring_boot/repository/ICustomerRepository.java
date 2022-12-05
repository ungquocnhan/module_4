package com.codegym.management_customer_spring_boot.repository;

import com.codegym.management_customer_spring_boot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
