import Products.ExpirableShippableProduct;
import Products.Product;
import Products.ShippableProduct;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ali", 1000);

        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, LocalDate.of(2025, 8, 10), 0.4);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, LocalDate.of(2025, 8, 1), 0.7);
        Product tv = new ShippableProduct("Samsung TV", 5000, 2, 10);
        Product scratchCard = new Product("Vodafone Card", 20, 10) {
        };

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}