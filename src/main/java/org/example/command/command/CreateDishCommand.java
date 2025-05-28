package org.example.command.command;

import java.util.UUID;

public class CreateDishCommand implements Command{
    private final String commandId;
    private final String id;
    private final String name;
    private final double price;

    public CreateDishCommand(String name, double price) {
        this.price = price;
        this.commandId = UUID.randomUUID().toString();
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String getCommandId() {
        return commandId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
