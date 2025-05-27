package org.example.query.dto;

import org.example.command.model.Dish;
import org.example.command.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private String id;
    private String clientName;
    private List<DishDto> dishes;
    private OrderStatus orderStatus;
    private LocalDateTime orderedTime;

    public OrderDto(String id, String clientName, List<DishDto> dishes, OrderStatus orderStatus, LocalDateTime orderedTime) {
        this.id = id;
        this.clientName = clientName;
        this.dishes = dishes;
        this.orderStatus = orderStatus;
        this.orderedTime = orderedTime;
    }

    public String getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public List<DishDto> getDishes() {
        return dishes;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }
}
