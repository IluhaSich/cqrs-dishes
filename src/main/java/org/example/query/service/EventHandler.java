package org.example.query.service;

import org.example.command.model.OrderStatus;
import org.example.common.event.*;
import org.example.query.model.DishView;
import org.example.query.model.OrderView;
import org.example.query.repository.DishViewRepository;
import org.example.query.repository.OrderViewRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventHandler implements EventBus.EventHandler{
    private final OrderViewRepository orderViewRepository;
    private final DishViewRepository dishViewRepository;

    public EventHandler(OrderViewRepository orderViewRepository, DishViewRepository dishViewRepository) {
        this.orderViewRepository = orderViewRepository;
        this.dishViewRepository = dishViewRepository;
    }

    @Override
    public void handle(Event event) {
        if (event instanceof OrderCreatedEvent) {
            handleOrderCreated((OrderCreatedEvent) event);
        } else if (event instanceof ChangeStatusEvent) {
            handleChangeStatus((ChangeStatusEvent) event);
        } else if (event instanceof AddDishEvent) {
            handleAddDish((AddDishEvent) event);
        } else if (event instanceof RemoveDishEvent) {
            handleRemoveDish((RemoveDishEvent) event);
        }
    }


    private void handleOrderCreated(OrderCreatedEvent event) {
        OrderView orderView = new OrderView(
                event.getId(),
                event.getClientName(),
                new ArrayList<>(),
                OrderStatus.created,
                LocalDateTime.now()
        );

        orderViewRepository.save(orderView);
    }

    private void handleAddDish(AddDishEvent event) {
        OrderView order = orderViewRepository.findById(event.getOrderId());
        DishView dish = dishViewRepository.findById(event.getDishId());
        List<DishView> dishViews = order.getDishes();
        dishViews.add(dish);
        order.setDishes(dishViews);
        orderViewRepository.save(order);
    }

    private void handleRemoveDish(RemoveDishEvent event) {
        OrderView order = orderViewRepository.findById(event.getOrderId());
        DishView dish = dishViewRepository.findById(event.getDishId());
        List<DishView> dishViews = order.getDishes();
        dishViews.remove(dish);
        order.setDishes(dishViews);
        orderViewRepository.save(order);
    }

    private void handleChangeStatus(ChangeStatusEvent event) {
        var order = orderViewRepository.findById(event.getId());
        order.setOrderStatus(event.getOrderStatus());
        orderViewRepository.save(order);
    }

}
