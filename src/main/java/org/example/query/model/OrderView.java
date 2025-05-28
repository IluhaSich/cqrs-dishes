package org.example.query.model;

import org.example.command.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderView {
    private String id;
    private String clientName;
    private List<DishView> dishes;
    private OrderStatus orderStatus;
    private LocalDateTime orderedTime;

    public OrderView(String id, String clientName, List<DishView> dishes, OrderStatus orderStatus, LocalDateTime orderedTime) {
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

    public List<DishView> getDishes() {
        return dishes;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setDishes(List<DishView> dishes) {
        this.dishes = dishes;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
    }

    public double getTotalPrice() {
        if (dishes == null || dishes.isEmpty()) {
            return 0;
        }

        return dishes.stream()
                .mapToDouble(DishView::getPrice)
                .sum();
    }

}
