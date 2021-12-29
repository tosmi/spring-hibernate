package at.stderr.springdemo.dao;

import at.stderr.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}
