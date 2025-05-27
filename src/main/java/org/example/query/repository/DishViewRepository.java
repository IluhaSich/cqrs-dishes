package org.example.query.repository;

import org.example.query.model.DishView;

import java.util.*;

public class DishViewRepository {
    private final Map<String, DishView> dishes = new HashMap<>();

    public void save(DishView dishView) {
        dishes.put(dishView.getId(), dishView);
    }

    public DishView findById(String id) {
        return Optional.ofNullable(dishes.get(id))
                .orElseThrow(() -> new NoSuchElementException("Блюдо не найдено: " + id));
    }


    public List<DishView> findAll() {
        return new ArrayList<>(dishes.values());
    }
}
