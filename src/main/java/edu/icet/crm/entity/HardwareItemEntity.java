package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hardwareitem")
@Getter
@Setter
public class HardwareItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemID;
    private String name;
    private Double renetelPerDay;
    private Double finePerDay;
    private String availability;
}
