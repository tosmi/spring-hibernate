package at.stderr.springdemo.service;

import at.stderr.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}
