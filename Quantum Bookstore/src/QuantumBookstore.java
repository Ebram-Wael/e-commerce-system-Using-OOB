import Books.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuantumBookstore {
    private Map<String, Book> inventory;

    public QuantumBookstore() {
        inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
    }

    public Book removeBook(String isbn) {
        Book removed = inventory.remove(isbn);
        if (removed != null)
            System.out.println("Quantum book store: Book removed - " + removed.getISBN());
        else
            System.out.println("Quantum book store: Book not found.");
        return removed;
    }

    public List<Book> removeOutdatedBooks(int yearLimit) {
        List<Book> expiredBooks = new ArrayList<>();
        int currentYear = Year.now().getValue();
        for (Book book : inventory.values()) {
            if (currentYear - book.getYear() > yearLimit) {
                expiredBooks.add(book);
                inventory.remove(book.getISBN());
                System.out.println("Quantum book store: Removed outdated book - " + book.getISBN());
            }
        }
        return expiredBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = inventory.get(isbn);
        if (book == null)
            throw new Exception("Quantum book store: Book not found.");

        if (!book.isSellable())
            throw new Exception("Quantum book store: This book is not for sale.");

        return book.buy(email, address, quantity);
    }

    public void printInventory() {
        System.out.println("Quantum book store: Inventory:");
        for (Book book : inventory.values()) {
            System.out.println("- " + book.getTitle() + " (" + book.getISBN() + ")");
        }
    }
}
