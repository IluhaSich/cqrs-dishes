package org.example.query.service;

import org.example.query.dto.DishDto;
import org.example.query.model.DishView;
import org.example.query.repository.DishViewRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DishQueryService {
    private final DishViewRepository dishViewRepository;

    public DishQueryService(DishViewRepository dishViewRepository) {
        this.dishViewRepository = dishViewRepository;
    }

    private DishDto convertToDto(DishView dishView){
        return new DishDto(
                dishView.getId(),
                dishView.getName(),
                dishView.getPrice()
        );
    }

    public DishDto getDishById(String id) {
        DishView account = dishViewRepository.findById(id);
        return convertToDto(account);
    }

    public List<DishDto> getAllDishes() {
        return dishViewRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<DishDto> getDishes(List<DishView> dishViews) {
        return dishViews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
