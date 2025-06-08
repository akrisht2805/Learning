import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * You are given a list of orders. Each Order has fields: orderId, userId, amount, and status (e.g., PLACED, CANCELLED, DELIVERED).
 * Using Java Streams:
 * Find the total amount spent by each user only for orders with status DELIVERED.
 * Return a Map<String, Double> where key = userId, value = total delivered amount.
 * */

public class Stream6 {

    public static class Order {
        private String orderId;
        private String userId;
        private double amount;
        private String status;

        public Order(String orderId, String userId, double amount, String status) {
            this.orderId = orderId;
            this.userId = userId;
            this.amount = amount;
            this.status = status;
        }

        // Getters
        public String getOrderId() { return orderId; }
        public String getUserId() { return userId; }
        public double getAmount() { return amount; }
        public String getStatus() { return status; }
    }

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("O1", "U1", 250.0, "DELIVERED"),
                new Order("O2", "U1", 150.0, "CANCELLED"),
                new Order("O3", "U2", 500.0, "DELIVERED"),
                new Order("O4", "U1", 100.0, "DELIVERED"),
                new Order("O5", "U3", 300.0, "PLACED")
        );

        Map<String,Double> ans = orders.stream().filter(order-> order.status.equals("DELIVERED") )
                .collect(Collectors.groupingBy(order->order.userId, Collectors.summingDouble(order->order.amount)));

        ans.forEach((key,value)->{
            System.out.println(key+" => "+value);
        });

    }
}
