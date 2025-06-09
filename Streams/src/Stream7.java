import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given a list of Product objects with fields: id, name, category, price.
 * Using Java Streams:
 * Group all products by category.
 * Then, for each category, return the list of product names sorted by price (ascending).
 * Result should be a Map<String, List<String>> → category to sorted product names.
 * */

public class Stream7 {

    public static class Product {
        private int id;
        private String name;
        private String category;
        private double price;

        public Product(int id, String name, String category, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }

    }


    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product(1, "iPhone", "Electronics", 999.99),
                new Product(2, "Laptop", "Electronics", 1200.00),
                new Product(3, "Mouse", "Electronics", 25.00),
                new Product(4, "T-Shirt", "Clothing", 19.99),
                new Product(5, "Jeans", "Clothing", 49.99)
        );

        Map<String,List<String>> res = products.stream().
                collect(Collectors.groupingBy(product->product.category,Collectors.collectingAndThen(
                        Collectors.toList(),
                        list->list.stream().sorted(Comparator.comparingDouble(ele->ele.price)).map(ele->ele.name).toList()

                )));


        res.forEach((k,v)->{
            System.out.println(k+" => [");
            v.forEach(ele-> System.out.println("    "+ele));
            System.out.println("]");
        });


    }
}
