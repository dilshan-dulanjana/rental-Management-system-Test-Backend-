package edu.icet.crm.service;

import edu.icet.crm.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer persist( Customer customer);

    List<Customer> getAllCustomers();

    Customer searchCustomer(Long id);

    Customer updateCustomer(Customer customer ,Long id);

    boolean deleteCustomer(Long id);
}
