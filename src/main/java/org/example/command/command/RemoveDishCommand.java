package org.example.command.command;

public class RemoveDishCommand implements Command{
    private final String dishId;

    public RemoveDishCommand(String dishId) {
        this.dishId = dishId;
    }

    public String getDishId() {
        return dishId;
    }
}
