import Products.Expirable;
import Products.Product;
import Products.ShippableProduct;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import java.time.LocalDate;
import java.util.List;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        validateCart(cart);
        double subtotal = calculateSubtotal(cart);
        List<ShippableProduct> shippableItems = cart.getShippableItems();
        double shippingFee = calculateShippingIfNeeded(shippableItems);
        double total = subtotal + shippingFee;
        validateCustomerBalance(customer, total);
        customer.pay(total);
        reduceProductQuantities(cart);
        printReceipt(cart, subtotal, shippingFee, total, customer);
    }

    private static void validateCart(Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("❌ Cart is empty");
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product instanceof Expirable expirable) {
                if (expirable.getExpiryDate().isBefore(LocalDate.now())) {
                    throw new IllegalStateException("❌ " + product.getName() + " is expired");
                }
            }

            if (product.getQuantity() < item.getQuantity()) {
                throw new IllegalStateException("❌ " + product.getName() + " is out of stock");
            }
        }
    }

    private static double calculateSubtotal(Cart cart) {
        return cart.getSubtotal();
    }

    private static double calculateShippingIfNeeded(List<ShippableProduct> shippableItems) {
        return shippableItems.isEmpty()
                ? 0
                : ShippingService.handleShipment(shippableItems);
    }

    private static void validateCustomerBalance(Customer customer, double total) {
        if (customer.getBalance() < total) {
            throw new IllegalStateException("❌ Customer balance is insufficient");
        }
    }

    private static void reduceProductQuantities(Cart cart) {
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
    }

    private static void printReceipt(Cart cart, double subtotal, double shippingFee, double total, Customer customer) {
        System.out.println("** Checkout receipt **");

        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName());
            System.out.println((int) item.getTotalPrice());
        }

        System.out.println("----------------------");
        System.out.println("Subtotal         " + (int) subtotal);
        System.out.println("Shipping         " + (int) shippingFee);
        System.out.println("Amount           " + (int) total);
        System.out.println("Customer balance after payment: " + customer.getBalance());
        System.out.println("END.");
    }
}

