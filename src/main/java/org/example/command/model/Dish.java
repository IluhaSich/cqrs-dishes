package org.example.command.model;

import org.example.common.event.DishCreatedEvent;
import org.example.common.event.EventBus;

public class Dish {
    private final String id;
    private String name;
    private double price;


    public Dish(String Id, String name, double price) {
        this.id = Id;
        this.name = name;
        this.price = price;

        EventBus.getInstance().publish(
                new DishCreatedEvent(id,name,price)
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
