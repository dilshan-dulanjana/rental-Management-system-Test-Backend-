package edu.icet.crm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Customer {

    private  Long customerID;
    private String name;
    private String contact;
    private String city;


}
