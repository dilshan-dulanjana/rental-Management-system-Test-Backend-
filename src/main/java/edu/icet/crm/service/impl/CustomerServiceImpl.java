package edu.icet.crm.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.model.Customer;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectMapper mapper;

    @Override
    public Customer persist(Customer customer) {
        CustomerEntity save = customerRepository.save(
                mapper.convertValue(
                        customer, CustomerEntity.class));
        return mapper.convertValue(
                save, Customer.class);
    }

    @Override
    public List<Customer> getAllCustomers() {

        Iterable<CustomerEntity> allCustomersEntities = customerRepository.findAll();
        List<Customer> allCyustomers = new ArrayList<>();

        for (CustomerEntity entity : allCustomersEntities) {

            allCyustomers.add(
                    mapper.convertValue(entity, Customer.class));
        }

        return allCyustomers;
    }

    @Override
    public Customer searchCustomer(Long id) {

        return mapper.convertValue(
                customerRepository.findById(id).get(),Customer.class);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        CustomerEntity newEntity = mapper.convertValue(
                customer, CustomerEntity.class);
        if(customerEntity.isPresent()){
            CustomerEntity oldEntity = customerEntity.get();
            oldEntity.setName(newEntity.getName());
            oldEntity.setCity(newEntity.getCity());
            oldEntity.setContact(newEntity.getContact());
            customerRepository.save(oldEntity);
            return customer;
        }
        return mapper.convertValue(
                customerEntity.get(),Customer.class);

    }

    @Override
    public boolean deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return true;
    }
}
