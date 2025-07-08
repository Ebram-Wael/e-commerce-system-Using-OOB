package Books;

public class PaperBook extends Book {

    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    @Override
    public double buy(String email, String address, int quantity) throws Exception {
        if (!isSellable())
            throw new Exception("Quantum book store: This book is not for sale.");

        if (stock < quantity)
            throw new Exception("Quantum book store: Not enough stock available.");

        stock -= quantity;


        double amount = this.getPrice() * quantity;
        System.out.println("Quantum book store: Paper book purchased. Amount paid = " + amount);
        return amount;
    }
}
