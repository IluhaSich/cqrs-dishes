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
            System.out.println("\n===== Систему управления заказами =====");
            System.out.println("1. Создать заказ");
            System.out.println("2. Создать блюдо");
            System.out.println("3. Добавить блюдо в заказ");
            System.out.println("4. Убрать блюдо из заказа");
            System.out.println("5. Поменять статус заказа");
            System.out.println("6. Показать все заказы");
            System.out.println("7. Показать все блюда");
            System.out.println("8. Показать статистику заказов");
            System.out.println("0. Выход");
            System.out.println("Выберите действие:");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createOrder();
                    break;
                case "2":
                    createDish();
                    break;
                case "3":
                    addDishToOrder();
                    break;
                case "4":
                    removeDishFromOrder();
                    break;
                case "5":
                    changeOrderStatus();
                    break;
                case "6":
                    showAllOrders();
                    break;
                case "7":
                    showAllDishes();
                    break;
                case "8":
                    getOrderStatistics();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private void getOrderStatistics() {
        var stat = facade.getOrderStatistics();
        System.out.println(stat);
    }


    private void createDish() {
        System.out.print("Введите название блюда: ");
        String dishName = scanner.nextLine();
        System.out.print("Введите стоимость блюда: ");
        Double price = Double.parseDouble(scanner.nextLine());
        facade.createDish(dishName,price);
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

    private void removeDishFromOrder() {
        System.out.print("Введите ID заказа: ");
        String orderId = scanner.nextLine();
        System.out.print("Введите ID блюда: ");
        String dishId = scanner.nextLine();
        facade.removeDishFromOrder(orderId, dishId);
        System.out.println("Блюдо удалено из заказа");
    }

    private void changeOrderStatus() {
        System.out.print("Введите ID заказа: ");
        String orderId = scanner.nextLine();
        facade.changeOrderStatus(orderId);
        System.out.println("Статус заказа изменен");
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
