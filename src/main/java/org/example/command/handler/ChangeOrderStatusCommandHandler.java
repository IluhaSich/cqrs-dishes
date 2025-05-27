package org.example.command.handler;

import org.example.command.command.ChangeOrderStatusCommand;
import org.example.command.model.Order;
import org.example.command.repository.OrderRepository;

public class ChangeOrderStatusCommandHandler implements CommandHandler<ChangeOrderStatusCommand>{
    private final OrderRepository orderRepository;

    public ChangeOrderStatusCommandHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void handle(ChangeOrderStatusCommand command) {
        Order order = orderRepository.findById(command.getId());
        order.changeOrderStatus();
        orderRepository.save(order);
    }
}
