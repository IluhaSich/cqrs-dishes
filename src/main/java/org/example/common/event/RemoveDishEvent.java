package org.example.common.event;

public class RemoveDishEvent {
    private final String orderId;
    private final String dishId;
    private final String name;

    public RemoveDishEvent(String orderId, String dishId, String name) {
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
