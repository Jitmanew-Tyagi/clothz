package com.clothz.OrderService.service;

import com.clothz.OrderService.dto.OrderRequest;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    public ResponseEntity<String> placeOrder(OrderRequest orderRequest);
}
