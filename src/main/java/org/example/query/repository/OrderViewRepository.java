package org.example.query.repository;

import org.example.query.model.OrderView;

import java.util.*;

public class OrderViewRepository {
    private final Map<String, OrderView> orders = new HashMap<>();

    public void save(OrderView OrderView) {
        orders.put(OrderView.getId(), OrderView);
    }

    public OrderView findById(String id) {
        return Optional.ofNullable(orders.get(id))
                .orElseThrow(() -> new NoSuchElementException("Заказ не найден: " + id));
    }


    public List<OrderView> findAll() {
        return new ArrayList<>(orders.values());
    }
}
