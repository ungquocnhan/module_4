package management_customer.service;

import management_customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void update(int id, Customer customer);

    void remove(int id);
}
