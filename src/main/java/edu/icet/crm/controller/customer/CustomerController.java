package edu.icet.crm.controller.customer;

import edu.icet.crm.model.Customer;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("/customer")
    public Customer persist(@RequestBody Customer customer) {

        return customerService.persist(customer);
    }


}
