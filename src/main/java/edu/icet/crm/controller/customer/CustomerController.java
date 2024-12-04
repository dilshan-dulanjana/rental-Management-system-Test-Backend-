package edu.icet.crm.controller.customer;

import edu.icet.crm.model.Customer;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("/customer")
    public Customer persist(@RequestBody Customer customer) {

        return customerService.persist(customer);
    }


    @GetMapping("/getAllCustomers")
    List <Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/searchCustomer/id")
    public Customer searchCustomer(@RequestParam  Long id){
        return customerService.searchCustomer(id);

    }

    @PutMapping("/updateCustomer/id")
    public Customer updateCustomer(@RequestBody Customer customer ,@RequestParam  Long id){
        return customerService.updateCustomer(customer,id);
    }

    @DeleteMapping("/deleteCustomer/id")
    public boolean deletCustomer(@RequestParam Long id){
        return customerService.deleteCustomer(id);
    }

}
