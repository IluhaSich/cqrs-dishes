package org.example.query.dto;

public class OrdersStatisticsDto {
    private int orderCount;
    private double averageTotalPrice;
    private double largestTotalPrice;

    public OrdersStatisticsDto(int orderCount, double averageTotalPrice, double largestTotalPrice) {
        this.orderCount = orderCount;
        this.averageTotalPrice = averageTotalPrice;
        this.largestTotalPrice = largestTotalPrice;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public double getAverageTotalPrice() {
        return averageTotalPrice;
    }

    public double getLargestTotalPrice() {
        return largestTotalPrice;
    }

    @Override
    public String toString() {
        return "\n==== Статистика по заказам ====\n" +
                "Количество заказов: " + orderCount + "\n" +
                "Средний чек: " + averageTotalPrice + "\n" +
                "Наибольший чек: " + largestTotalPrice;
    }
}
