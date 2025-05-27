package org.example.command.handler;

import org.example.command.command.RemoveDishCommand;
import org.example.command.model.Dish;
import org.example.command.model.Order;
import org.example.command.repository.DishRepository;
import org.example.command.repository.OrderRepository;

public class RemoveDishCommandHandler implements CommandHandler<RemoveDishCommand>{
    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;

    public RemoveDishCommandHandler(OrderRepository orderRepository, DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
    }


    @Override
    public void handle(RemoveDishCommand command) {
        Dish dish = dishRepository.findById(command.getDishId());
        Order order = orderRepository.findById(command.getOrderId());
        order.getDishes().remove(dish);
        orderRepository.save(order);
    }
}
