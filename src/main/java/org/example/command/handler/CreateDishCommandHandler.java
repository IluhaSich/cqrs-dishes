package org.example.command.handler;

import org.example.command.command.CreateDishCommand;
import org.example.command.model.Dish;
import org.example.command.repository.DishRepository;

public class CreateDishCommandHandler implements CommandHandler<CreateDishCommand>{
    private final DishRepository dishRepository;

    public CreateDishCommandHandler(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public void handle(CreateDishCommand command) {
        Dish dish = new Dish(
                command.getId(),
                command.getName(),
                command.getPrice()
        );

        dishRepository.save(dish);
    }
}
