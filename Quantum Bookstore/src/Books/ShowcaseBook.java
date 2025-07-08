package Books;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String ISBN, String title, String author, int year, double price) {
        super(ISBN, title, author, year, price);
    }

    @Override
    public boolean isSellable() {
        return false;
    }

    @Override
    public double buy(String email, String address, int quantity) throws Exception {
        throw new Exception("Quantum book store: Showcase books are not for sale.");
    }
}
