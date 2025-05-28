package org.example.query.service;

import org.example.query.dto.OrderDto;
import org.example.query.dto.OrdersStatisticsDto;
import org.example.query.model.OrderView;
import org.example.query.repository.DishViewRepository;
import org.example.query.repository.OrderViewRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderQueryService {
    private final DishViewRepository dishViewRepository;
    private final OrderViewRepository orderViewRepository;
    private final DishQueryService dishQueryService;

    public OrderQueryService(DishViewRepository dishViewRepository, OrderViewRepository orderViewRepository, DishQueryService dishQueryService) {
        this.dishViewRepository = dishViewRepository;
        this.orderViewRepository = orderViewRepository;
        this.dishQueryService = dishQueryService;
    }

    private OrderDto convertToDto(OrderView orderDto){
        return new OrderDto(
                orderDto.getId(),
                orderDto.getClientName(),
                dishQueryService.getDishes(orderDto.getDishes()),
                orderDto.getOrderStatus(),
                orderDto.getOrderedTime()
        );
    }

    public OrderDto getOrderById(String id) {
        OrderView account = orderViewRepository.findById(id);
        return convertToDto(account);
    }

    public List<OrderDto> getAllOrders() {
        return orderViewRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public OrdersStatisticsDto getOrdersStatistics() {
        List<OrderView> orders = orderViewRepository.findAll();

        int orderCount = orders.size();

        double averageTotalPrice = orders.isEmpty() ? 0 :
                orders.stream()
                        .mapToDouble(OrderView::getTotalPrice)
                        .average()
                        .orElse(0);

        double largestTotalPrice = orders.stream()
                .mapToDouble(OrderView::getTotalPrice)
                .max()
                .orElse(0);

        return new OrdersStatisticsDto(orderCount, averageTotalPrice, largestTotalPrice);
    }
}
