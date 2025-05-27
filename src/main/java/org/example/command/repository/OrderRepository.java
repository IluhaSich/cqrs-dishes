package org.example.command.repository;

import org.example.command.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OrderRepository implements Repository<Order>{
    private final Map<String, Order> orders = new HashMap<>();

    @Override
    public void save(Order order) {
        orders.put(order.getId(),order);
    }

    @Override
    public Order findById(String id) {
        return Optional.ofNullable(orders.get(id))
                .orElseThrow(() -> new NoSuchElementException("Заказ не найден: " + id));
    }
}
