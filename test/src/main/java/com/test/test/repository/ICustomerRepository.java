package com.test.test.repository;

import com.test.test.dto.CustomerView;
import com.test.test.model.Customer;
import com.test.test.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.id, c.name, c.birthday, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.customer_type_id as customerType, c.address from customer c WHERE c.flag = 1 and (c.name like concat('%' , :name , '%') and c.email like concat('%' , :email , '%') and c.customer_type_id like concat('%' , :customerType , '%'))",
            countQuery = "select * from (select c.id, c.name, c.birthday, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.customer_type_id as customerType, c.address from customer c WHERE c.flag = 1 and (c.name like concat('%' , :name , '%') and c.email like concat('%' , :email , '%') and c.customer_type_id like concat('%' , :customerType , '%'))) as count_page" ,
            nativeQuery = true)
    Page<CustomerView> findAllCustomerView(@Param("name") String name, @Param("email") String email, @Param("customerType") String customerType, Pageable pageable);


    Page<CustomerView> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);
    Page<CustomerView> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);
}
