package Books;

public abstract class Book {
    private String ISBN;
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String ISBN, String title, String author, int year, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getISBN() {
        return ISBN;
    }

    public abstract double buy(String email, String address, int quantity) throws Exception;

    public boolean isSellable() {
        return true;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }
}
