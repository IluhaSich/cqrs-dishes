package org.example.command.command;

import org.example.command.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateOrderCommand implements Command{
    private final String commandId;
    private final String id;
    private final String clientName;
    private final OrderStatus orderStatus;
    private final LocalDateTime orderedTime;

    public CreateOrderCommand(String clientName) {
        this.clientName = clientName;
        this.commandId = UUID.randomUUID().toString();
        this.id = UUID.randomUUID().toString();
        this.orderStatus = OrderStatus.created;
        this.orderedTime = LocalDateTime.now();
    }

    public String getClientName() {
        return clientName;
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

    @Override
    public String getCommandId() {
        return commandId;
    }
}
