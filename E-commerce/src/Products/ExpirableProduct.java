package Products;

import java.time.LocalDate;
import java.util.*;

public class ExpirableProduct extends Product implements Expirable{
    private final LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate date) {
        super(name, price, quantity);
        this.expiryDate = date;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
