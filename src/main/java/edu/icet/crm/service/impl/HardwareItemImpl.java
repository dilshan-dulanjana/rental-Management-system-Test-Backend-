package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.repository.HardwareItemRepository;
import edu.icet.crm.service.HardwareItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardwareItemImpl implements HardwareItemService {
    private final HardwareItemRepository hardwareItemRepository;
    private final ObjectMapper mapper;
    @Override
    public HardwareItem persist(HardwareItem hardwareItem) {
        HardwareItemEntity save = hardwareItemRepository.save(
                mapper.convertValue(
                        hardwareItem, HardwareItemEntity.class));
        return  mapper.convertValue(save,HardwareItem.class);
    }

    @Override
    public boolean deleteCustomer(Long id) {

        hardwareItemRepository.deleteById(id);
        return true;
    }

    @Override
    public HardwareItem updateItem(HardwareItem hardwareItem, Long id) {
        Optional<HardwareItemEntity> itemEntity = hardwareItemRepository.findById(id);
        HardwareItemEntity newEntity = mapper.convertValue(
                hardwareItem, HardwareItemEntity.class);
        if(itemEntity.isPresent()){
            HardwareItemEntity oldEntity = itemEntity.get();
            oldEntity.setName(newEntity.getName());
            oldEntity.setAvailability(newEntity.getAvailability());
            oldEntity.setFinePerDay(newEntity.getFinePerDay());
            oldEntity.setRenetelPerDay(newEntity.getRenetelPerDay());
            hardwareItemRepository.save(oldEntity);
            return hardwareItem;
        }
        return mapper.convertValue(
                itemEntity.get(),HardwareItem.class);
    }

    @Override
    public HardwareItem searchItem(Long id) {

        return mapper.convertValue(
                hardwareItemRepository.findById(id).get(),HardwareItem.class);
    }

    @Override
    public List<HardwareItem> getAllItems() {
        Iterable<HardwareItemEntity> allEntitys = hardwareItemRepository.findAll();
        List<HardwareItem> hardwareItemList = new ArrayList<>();

        for(HardwareItemEntity entity: allEntitys){
            hardwareItemList.add(
                    mapper.convertValue(entity,HardwareItem.class));
        }
        return hardwareItemList;
    }
}
