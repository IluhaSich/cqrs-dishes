package org.example.command.command;

import org.example.command.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateOrderCommand implements Command{
    private final String id;
    private final OrderStatus orderStatus;
    private final LocalDateTime orderedTime;

    public CreateOrderCommand(String id) {
        this.id = UUID.randomUUID().toString();
        this.orderStatus = OrderStatus.created;
        this.orderedTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }
}
