package org.example.command.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private final String ID;
    private List<Dish> dishes;
    private OrderStatus orderStatus;
    private LocalDateTime orderedTime;

    public Order(String id) {
        ID = id;
    }
}
