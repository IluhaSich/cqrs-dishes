package org.example.command.command;

public class AddDishCommand implements Command{
    private final String dishId;

    public AddDishCommand(String dishId) {
        this.dishId = dishId;
    }

    public String getDishId() {
        return dishId;
    }
}
