package edu.icet.crm.service;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HardwareItemService {


  public  HardwareItem persist(HardwareItem hardwareItem);

    boolean deleteCustomer(Long id);

  HardwareItem updateItem(HardwareItem hardwareItem, Long id);

  HardwareItem searchItem(Long id);

  List<HardwareItem> getAllItems();
}
