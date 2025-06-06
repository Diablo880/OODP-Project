import java.time.LocalDate;

public class Transaction {
    private int transactionID;
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Transaction(int transactionID, Member member, Book book, LocalDate borrowDate) {
        this.transactionID = transactionID;
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public int getTransactionID() { return transactionID; }

    public Member getMember() { return member; }

    public Book getBook() { return book; }

    public LocalDate getReturnDate() { return returnDate; }

    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public LocalDate calculateDueDate() {
        return switch (member.getMembershipType().toLowerCase()) {
            case "premium" -> borrowDate.plusWeeks(4);
            case "regular" -> borrowDate.plusWeeks(2);
            case "guest" -> borrowDate.plusWeeks(1);
            default -> borrowDate.plusWeeks(1);
        };
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + ", Member: " + member.getName() +
               ", Book: " + book.getTitle() + ", Borrowed On: " + borrowDate +
               ", Due: " + calculateDueDate();
    }
}
