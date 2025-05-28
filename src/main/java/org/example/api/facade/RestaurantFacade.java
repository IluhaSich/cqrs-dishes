package org.example.api.facade;

import org.example.command.command.*;
import org.example.command.handler.CommandBus;
import org.example.query.dto.DishDto;
import org.example.query.dto.OrderDto;
import org.example.query.dto.OrdersStatisticsDto;
import org.example.query.service.DishQueryService;
import org.example.query.service.OrderQueryService;

import java.util.List;

public class RestaurantFacade {
    private final CommandBus commandBus;
    private final OrderQueryService orderQueryService;
    private final DishQueryService dishQueryService;

    public RestaurantFacade(CommandBus commandBus,
                            OrderQueryService orderQueryService,
                            DishQueryService dishQueryService) {
        this.commandBus = commandBus;
        this.orderQueryService = orderQueryService;
        this.dishQueryService = dishQueryService;
    }

    public void createOrder(String clientName) {
        CreateOrderCommand command = new CreateOrderCommand(clientName);
        commandBus.dispatch(command);
    }

    public void createDish(String dishName, Double price) {
        CreateDishCommand command = new CreateDishCommand(dishName,price);
        commandBus.dispatch(command);
    }

    public void addDishToOrder(String orderId, String dishId) {
        AddDishCommand command = new AddDishCommand(orderId, dishId);
        commandBus.dispatch(command);
    }

    public void removeDishFromOrder(String orderId, String dishId) {
        RemoveDishCommand command = new RemoveDishCommand(orderId, dishId);
        commandBus.dispatch(command);
    }

    public void changeOrderStatus(String orderId) {
        ChangeOrderStatusCommand command = new ChangeOrderStatusCommand(orderId);
        commandBus.dispatch(command);
    }

    public List<OrderDto> getAllOrders() {
        return orderQueryService.getAllOrders();
    }

    public List<DishDto> getAllDishes() {
        return dishQueryService.getAllDishes();
    }


    public OrdersStatisticsDto getOrderStatistics() { return orderQueryService.getOrdersStatistics();}
}

