package org.example.common.event;

import java.time.LocalDateTime;

public class AddDishEvent extends Event{
    private final String orderId;
    private final String dishId;
    private final String name;

    public AddDishEvent(String orderId, String dishId, String name) {
        super();
        this.orderId = orderId;
        this.dishId = dishId;
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }
}
