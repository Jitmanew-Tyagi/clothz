package com.clothz.inventory.service;

import com.clothz.inventory.dto.responses.InventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    public List<InventoryResponse> isInStock(List<String> skuCode);
}
