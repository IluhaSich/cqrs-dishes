package org.example.command.command;

import java.util.UUID;

public class AddDishCommand implements Command{
    private final String commandId;
    private final String orderId;
    private final String dishId;

    public AddDishCommand(String orderId, String dishId) {
        this.commandId = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.dishId = dishId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDishId() {
        return dishId;
    }

    @Override
    public String getCommandId() {
        return commandId;
    }
}
