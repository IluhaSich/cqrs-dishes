package org.example.api.console;

import org.example.api.facade.RestaurantFacade;
import org.example.query.dto.DishDto;
import org.example.query.dto.OrderDto;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private final RestaurantFacade facade;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleInterface(RestaurantFacade facade) {
        this.facade = facade;
    }

    public void start() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать заказ");
            System.out.println("2. Добавить блюдо в заказ");
            System.out.println("3. Убрать блюдо из заказа");
            System.out.println("4. Поменять статус заказа");
            System.out.println("5. Показать все заказы");
            System.out.println("6. Показать все блюда");
            System.out.println("0. Выход");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createOrder();
                    break;
                case "2":
                    addDishToOrder();
                    break;
                case "3":
                    addDishToOrder();
                    break;
                case "4":
                    changeOrderStatus();
                    break;
                case "5":
                    showAllOrders();
                    break;
                case "6":
                    showAllDishes();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private void createOrder() {
        System.out.print("Введите имя клиента: ");
        String clientName = scanner.nextLine();
        facade.createOrder(clientName);
        System.out.println("Заказ создан");
    }

    private void addDishToOrder() {
        System.out.print("Введите ID заказа: ");
        String orderId = scanner.nextLine();
        System.out.print("Введите ID блюда: ");
        String dishId = scanner.nextLine();
        facade.addDishToOrder(orderId, dishId);
        System.out.println("Блюдо добавлено в заказ");
    }

    private void changeOrderStatus() {
        System.out.print("Введите ID заказа: ");
        String orderId = scanner.nextLine();
        facade.changeOrderStatus(orderId);
        System.out.println("Заказ завершен");
    }

    private void showAllOrders() {
        List<OrderDto> orders = facade.getAllOrders();
        for (OrderDto order : orders) {
            System.out.println(order);
        }
    }

    private void showAllDishes() {
        List<DishDto> dishes = facade.getAllDishes();
        for (DishDto dish : dishes) {
            System.out.println(dish);
        }
    }
}
