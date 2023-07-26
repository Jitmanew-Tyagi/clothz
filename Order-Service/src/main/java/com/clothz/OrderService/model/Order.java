package com.clothz.OrderService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    String orderNumber;
    LocalDate orderDate;
    List<OrderLineItems> orderLineList;
    Integer cost;
}
