import Books.Book;
import Books.EBook;
import Books.PaperBook;
import Books.ShowcaseBook;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Book b1 = new EBook("b1", "oob", "Ebram", 2025, 150, "pdf");
        Book b2 = new EBook("b2", "java", "Ebram", 2015, 150, "word");
        Book b3 = new PaperBook("b3", "Database", "Bero", 2004, 250, 50);
        Book b4 = new PaperBook("b4", "Dart", "Sara", 2006, 500, 100);
        Book b5 = new ShowcaseBook("b5", "c++", "Bero", 1995, 1000);
        QuantumBookstore quantumBookstore = new QuantumBookstore();
        quantumBookstore.addBook(b1);
        quantumBookstore.addBook(b2);
        quantumBookstore.addBook(b3);
        quantumBookstore.addBook(b4);
        quantumBookstore.addBook(b5);
        quantumBookstore.printInventory();

        System.out.println("\n--- Buying PaperBook ---");
        double paperPrice = quantumBookstore.buyBook("b3", 2, "bero@email.com", "123 Cairo Street");
        System.out.println("Quantum book store: Total paid: " + paperPrice);

        System.out.println("\n--- Buying EBook ---");
        double ebookPrice = quantumBookstore.buyBook("b1", 1, "bob@email.com", "ignored address");
        System.out.println("Quantum book store: Total paid: " + ebookPrice);

        System.out.println("\n--- Attempt to Buy Showcase Book ---");
        try {
            quantumBookstore.buyBook("b5", 1, "hacker@email.com", "no way");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n--- Removing Outdated Books (>10 years) ---");
        QuantumBookstore store2 = new QuantumBookstore();


        store2.addBook(new PaperBook("ISBN004", "Old C++", "Coder", 2000, 70.0, 5));
        store2.addBook(new EBook("ISBN005", "Modern JS", "Frontend Dev", 2019, 80.0, "EPUB"));

        List<Book> removed = store2.removeOutdatedBooks(10);
        System.out.println("Quantum book store: Removed books:");
        for (Book b : removed) {
            System.out.println("- " + b.getTitle());
        }
    }


}
