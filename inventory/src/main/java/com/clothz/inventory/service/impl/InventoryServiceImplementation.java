package com.clothz.inventory.service.impl;

import com.clothz.inventory.dto.responses.InventoryResponse;
import com.clothz.inventory.model.Inventory;
import com.clothz.inventory.repository.InventoryRepository;
import com.clothz.inventory.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InventoryServiceImplementation implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public void saveSomeInstances() {
        Inventory inventory = Inventory.builder().skuCode("iphone-13").quantity(12).build();
        inventoryRepository.save(inventory);
        inventory = Inventory.builder().skuCode("iphone-14").quantity(10).build();
        inventoryRepository.save(inventory);
    }

    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Checking Inventory");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).collect(Collectors.toList());
    }
}