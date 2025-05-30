package org.example.common.event;

public class DishCreatedEvent extends Event{
    private final String id;
    private final String name;
    private final double price;

    public DishCreatedEvent(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
