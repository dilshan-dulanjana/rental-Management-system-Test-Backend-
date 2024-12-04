package edu.icet.crm.controller.hardwareItem;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.service.HardwareItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HardwareItemController {
    private final HardwareItemService hardwareItemService;

    @PostMapping("/hardwareitem")
    public HardwareItem persist(@RequestBody HardwareItem hardwareItem){
        return  hardwareItemService.persist(hardwareItem);
    }

    @GetMapping("/getItems")
    List<HardwareItem> getAllItems(){
        return hardwareItemService.getAllItems();
    }

    @GetMapping("/searchItem/id")
    public HardwareItem searchItem(@RequestParam Long id){
        return hardwareItemService.searchItem(id);

    }

    @PutMapping("/updateItem/id")
    public HardwareItem updateItem(@RequestBody HardwareItem hardwareItem ,@RequestParam  Long id){
        return hardwareItemService.updateItem(hardwareItem,id);
    }

    @DeleteMapping("/deleteItem/id")
    public boolean deleteItem(@RequestParam Long id){
        return hardwareItemService.deleteCustomer(id);
    }


}
