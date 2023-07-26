package com.clothz.inventory.controller;

import com.clothz.inventory.dto.responses.InventoryResponse;
import com.clothz.inventory.service.InventoryService;
import com.clothz.inventory.service.impl.InventoryServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryServiceImplementation inventoryService;

    @GetMapping("/placeOrder")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestBody List<String> skuCodes) {
        log.info("Received inventory check request for skuCode: {}", skuCodes);
        return inventoryService.isInStock(skuCodes);
    }
}
