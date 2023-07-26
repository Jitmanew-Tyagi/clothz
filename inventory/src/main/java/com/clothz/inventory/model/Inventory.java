package com.clothz.inventory.model;

import lombok.*;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Inventory {
    @Id
    private String id;
    private String skuCode;
    private Integer quantity;
}
