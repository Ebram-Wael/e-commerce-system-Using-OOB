import Products.Product;

class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Requested quantity > stock");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}