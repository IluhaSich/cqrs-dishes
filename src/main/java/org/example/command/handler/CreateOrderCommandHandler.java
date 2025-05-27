package org.example.command.handler;

import org.example.command.command.CreateOrderCommand;
import org.example.command.model.Order;
import org.example.command.repository.OrderRepository;

import java.util.ArrayList;

public class CreateOrderCommandHandler implements CommandHandler<CreateOrderCommand> {
    private final OrderRepository orderRepository;

    public CreateOrderCommandHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void handle(CreateOrderCommand command) {
        Order order = new Order(
                command.getId(),
                command.getClientName(),
                new ArrayList<>(),
                command.getOrderStatus(),
                command.getOrderedTime()
        );

        orderRepository.save(order);
    }
}
