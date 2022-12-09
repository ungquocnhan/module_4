package com.case_study.case_study_module_4.repository;

import com.case_study.case_study_module_4.dto.CustomerDto;
import com.case_study.case_study_module_4.dto.CustomerView;
import com.case_study.case_study_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c.id, c.name, c.birthday, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.customer_type_id as customerType, c.address, ct.name as typeName from customer c join customer_type ct on ct.id = c.customer_type_id WHERE c.flag = 1 and (c.name like concat('%' , :name , '%') and c.email like concat('%' , :email , '%') and ct.name like concat('%' , :customerType , '%'))",
            countQuery = "select * from (select c.id, c.name, c.birthday, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.customer_type_id as customerType, c.address, ct.name as typeName from customer c join customer_type ct on ct.id = c.customer_type_id WHERE c.flag = 1 and (c.name like concat('%' , :name , '%') and c.email like concat('%' , :email , '%') and ct.name like concat('%' , :customerType , '%'))) as nhan" ,
            nativeQuery = true)
    Page<CustomerView> findAllCustomerView(@Param("name") String name, @Param("email") String email, @Param("customerType") String customerType, Pageable pageable);

}
