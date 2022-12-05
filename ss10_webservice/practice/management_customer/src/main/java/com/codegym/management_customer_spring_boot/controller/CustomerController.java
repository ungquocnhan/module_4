package com.codegym.management_customer_spring_boot.controller;

import com.codegym.management_customer_spring_boot.model.Customer;
import com.codegym.management_customer_spring_boot.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer(){
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        if(customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int id){
        Optional<Customer> customer = customerService.findById(id);
        if(!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){
        Optional<Customer> customer = customerService.findById(id);
        if(!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customer.get(), HttpStatus.NOT_FOUND);
    }
}
