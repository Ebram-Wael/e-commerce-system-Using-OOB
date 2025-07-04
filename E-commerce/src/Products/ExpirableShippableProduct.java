package Products;

import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Expirable, Shippable {
    private final LocalDate expiryDate;
    private double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }


    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }
}
