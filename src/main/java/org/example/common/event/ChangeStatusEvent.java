package org.example.common.event;

import org.example.command.model.OrderStatus;

public class ChangeStatusEvent {
    private final String id;
    private final OrderStatus orderStatus;

    public ChangeStatusEvent(String id, OrderStatus orderStatus) {
        super();
        this.id = id;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
