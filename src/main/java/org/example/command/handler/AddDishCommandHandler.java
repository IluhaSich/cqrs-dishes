package org.example.command.handler;

import org.example.command.command.AddDishCommand;
import org.example.command.model.Order;
import org.example.command.repository.DishRepository;
import org.example.command.repository.OrderRepository;

public class AddDishCommandHandler implements CommandHandler<AddDishCommand>{
    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;

    public AddDishCommandHandler(OrderRepository orderRepository, DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public void handle(AddDishCommand command) {
        Order order = orderRepository.findById(command.getOrderId());
        order.addDish(dishRepository.findById(command.getDishId()));
        orderRepository.save(order);
    }
}
