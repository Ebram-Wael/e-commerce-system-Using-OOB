package Books;

public class EBook extends Book{
    private String fileType;

    public EBook(String ISBN, String title, String author, int year, double price, String fileType) {
        super(ISBN, title, author, year, price);
        this.fileType = fileType;
    }

    @Override
    public double buy(String email, String address, int quantity) throws Exception {
        if (!isSellable())
            throw new Exception("Quantum book store: This book is not for sale.");

        if (quantity != 1)
            throw new Exception("Quantum book store: EBooks can only be bought one at a time.");

        // simulate sending email
//        MailService.send(this, email);

        double amount = this.getPrice();
        System.out.println("Quantum book store: EBook sent to " + email + ". Amount paid = " + amount);
        return amount;
    }
}
