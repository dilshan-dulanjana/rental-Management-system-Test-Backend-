package edu.icet.crm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class HardwareItem {
    private String itemID;
    private String name;
    private Double renetelPerDay;
    private Double finePerDay;
    private String availability;
}
