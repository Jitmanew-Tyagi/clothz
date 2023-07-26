package com.clothz.OrderService.service.impl;


import com.clothz.OrderService.dto.OrderLineItemsDto;
import com.clothz.OrderService.dto.OrderRequest;
import com.clothz.OrderService.model.Order;
import com.clothz.OrderService.model.OrderLineItems;
import com.clothz.OrderService.repository.OrderRepository;
import com.clothz.OrderService.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseEntity<String> placeOrder(OrderRequest orderRequest) {
        log.info("Order creation request received");
        ResponseEntity<String> responseEntity;
        try {
            Order order = Order.builder()
                    .orderDate(LocalDate.now())
                    .orderLineList(orderRequest.getOrderLineItemsDtoList().stream()
                            .map(this::convertOrderLineListDtoToOrderLineList).collect(Collectors.toList())
                    ).build();
            orderRepository.save(order);
            log.info("Order Plced Successfully!");
            responseEntity = new ResponseEntity<>("Order Placed Successfully !!", HttpStatus.CREATED);
        } catch(Exception e) {
            log.error("Order Creation Failed !! \n{}", e.toString());
            responseEntity = new ResponseEntity<>("Order Creation Failed !!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    private OrderLineItems convertOrderLineListDtoToOrderLineList(OrderLineItemsDto orderLineItemsDtoList) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDtoList.getPrice());
        orderLineItems.setQuantity(orderLineItemsDtoList.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDtoList.getSkuCode());
        return orderLineItems;
    }
}
