package management_customer.service;

import management_customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
