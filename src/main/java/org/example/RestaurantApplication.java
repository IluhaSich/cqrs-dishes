package org.example;

import org.example.api.console.ConsoleInterface;
import org.example.api.facade.RestaurantFacade;
import org.example.command.command.*;
import org.example.command.handler.*;
import org.example.command.model.Dish;
import org.example.command.repository.DishRepository;
import org.example.command.repository.OrderRepository;
import org.example.common.event.EventBus;
import org.example.query.repository.DishViewRepository;
import org.example.query.repository.OrderViewRepository;
import org.example.query.service.DishQueryService;
import org.example.query.service.EventHandler;
import org.example.query.service.OrderQueryService;

import java.util.UUID;

public class RestaurantApplication {
    public static void main(String[] args) {
        // Инициализация репозиториев
        DishViewRepository dishViewRepository = new DishViewRepository();
        OrderViewRepository orderViewRepository = new OrderViewRepository();
        DishRepository dishRepository = new DishRepository();
        OrderRepository orderRepository = new OrderRepository();

        // Инициализация обработчиков событий
        EventHandler eventHandler = new EventHandler(orderViewRepository,dishViewRepository);
        EventBus.getInstance().register(eventHandler);

        // Инициализация командной шины и обработчиков команд
        CommandBus commandBus = new CommandBus();
        commandBus.register(CreateOrderCommand.class, new CreateOrderCommandHandler(orderRepository));
        commandBus.register(CreateDishCommand.class, new CreateDishCommandHandler(dishRepository));
        commandBus.register(AddDishCommand.class, new AddDishCommandHandler(orderRepository,dishRepository));
        commandBus.register(RemoveDishCommand.class, new RemoveDishCommandHandler(orderRepository,dishRepository));
        commandBus.register(ChangeOrderStatusCommand.class, new ChangeOrderStatusCommandHandler(orderRepository));

        // Инициализация сервиса запросов
        DishQueryService dishQueryService = new DishQueryService(dishViewRepository);
        OrderQueryService orderQueryService = new OrderQueryService(dishViewRepository,orderViewRepository,dishQueryService);

        // Инициализация фасада
        RestaurantFacade restaurantFacade = new RestaurantFacade(commandBus,orderQueryService,dishQueryService);

        // Создание тестовых данных
        try {
            dishRepository.save(new Dish(UUID.randomUUID().toString(), "Пицца: Четыре сыра", 800.0));
            dishRepository.save(new Dish(UUID.randomUUID().toString(), "Пицца: Карбонара", 650.0));
            dishRepository.save(new Dish(UUID.randomUUID().toString(), "Пицца: Ленин", 1650.0));
            dishRepository.save(new Dish(UUID.randomUUID().toString(), "Пицца: Пепперони", 440.0));
            dishRepository.save(new Dish(UUID.randomUUID().toString(), "Пицца: Пирог", 990.0));
            dishRepository.save(new Dish(UUID.randomUUID().toString(), "Сет из 4х пицц", 3440.0));

            restaurantFacade.createOrder("Илья");

            String order1Id = restaurantFacade.getAllOrders().get(0).getId();

            String dish1Id = restaurantFacade.getAllDishes().get(0).getId();
            String dish2Id = restaurantFacade.getAllDishes().get(2).getId();
            String dish3Id = restaurantFacade.getAllDishes().get(4).getId();

            restaurantFacade.addDishToOrder(order1Id, dish1Id);
            restaurantFacade.addDishToOrder(order1Id, dish2Id);
            restaurantFacade.addDishToOrder(order1Id, dish3Id);

            restaurantFacade.addDishToOrder(order1Id,dish1Id);
            restaurantFacade.removeDishFromOrder(order1Id,dish1Id);

            restaurantFacade.changeOrderStatus(order1Id);
            restaurantFacade.changeOrderStatus(order1Id);
            restaurantFacade.changeOrderStatus(order1Id);

            System.out.println("Тестовые данные успешно созданы");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ConsoleInterface consoleInterface = new ConsoleInterface(restaurantFacade);
        consoleInterface.start();
    }
}
