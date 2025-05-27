package org.example.command.repository;

import org.example.command.model.Dish;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DishRepository implements Repository<Dish> {
    private final Map<String, Dish> dishes = new HashMap<>();

    @Override
    public void save(Dish dish) {
        dishes.put(dish.getId(),dish);
    }

    @Override
    public Dish findById(String id) {
        return Optional.ofNullable(dishes.get(id))
                .orElseThrow(() -> new NoSuchElementException("Блюдо не найдено: " + id));
    }
}
