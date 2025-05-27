package org.example.command.model;

public enum OrderStatus {
    created("Создан"),
    applied("Принят"),
    cooking("Готовиться"),
    done("Готов");

    OrderStatus(String status) {
    }
}
