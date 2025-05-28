package org.example.query.service;

import org.example.common.event.*;
import org.example.query.repository.DishViewRepository;
import org.example.query.repository.OrderViewRepository;

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

    private void handleAddDish(AddDishEvent event) {
    }

    private void handleRemoveDish(RemoveDishEvent event) {

    }

    private void handleChangeStatus(ChangeStatusEvent event) {
    }

    private void handleOrderCreated(OrderCreatedEvent event) {
    }
}
