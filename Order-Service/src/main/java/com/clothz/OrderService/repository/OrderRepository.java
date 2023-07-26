package com.clothz.OrderService.repository;

import com.clothz.OrderService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
