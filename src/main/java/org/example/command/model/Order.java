package org.example.command.model;

import org.example.common.event.*;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private final String id;
    private final String clientName;
    private List<Dish> dishes;
    private OrderStatus orderStatus;
    private LocalDateTime orderedTime;

    public Order(String id, String clientName, List<Dish> dishes, OrderStatus orderStatus, LocalDateTime orderedTime) {
        this.id = id;
        this.clientName = clientName;
        this.dishes = dishes;
        this.orderStatus = orderStatus;
        this.orderedTime = orderedTime;

        EventBus.getInstance().publish(
            new OrderCreatedEvent(id,clientName)
        );
    }

    public String getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public void changeOrderStatus(){
        switch (this.getOrderStatus()){
            case created -> this.orderStatus = OrderStatus.applied;
            case applied -> this.orderStatus = OrderStatus.cooking;
            case cooking -> this.orderStatus = OrderStatus.done;
            case done -> System.out.println("Заказ уже готов");
        }

        EventBus.getInstance().publish(
            new ChangeStatusEvent(this.id,this.orderStatus)
        );
    }

    public void addDish(Dish dish){
        dishes.add(dish);
        EventBus.getInstance().publish(
                new AddDishEvent(this.id,dish.getId(),this.clientName)
        );
    }
    public void removeDish(Dish dish){
        dishes.remove(dish);
        EventBus.getInstance().publish(
                new RemoveDishEvent(this.id,dish.getId(),this.clientName)
        );
    }
}
