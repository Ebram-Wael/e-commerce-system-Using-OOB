import Products.Product;
import Products.ShippableProduct;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException(product.getName() + " doesn't have enough quantity");
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public List<ShippableProduct> getShippableItems() {
        List<ShippableProduct> list = new ArrayList<>();
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p instanceof ShippableProduct) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    list.add((ShippableProduct) p);
                }
            }
        }
        return list;
    }
}