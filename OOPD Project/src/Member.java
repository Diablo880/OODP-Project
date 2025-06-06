import java.util.ArrayList;

public class Member {
    private int memberID;
    private String name;
    private String membershipType;
    private ArrayList<Book> borrowedBooks;

    public Member() {
        this.memberID = 0;
        this.name = "";
        this.membershipType = "Guest";
        this.borrowedBooks = new ArrayList<>();
    }

    public Member(int memberID, String name, String membershipType) {
        this.memberID = memberID;
        this.name = name;
        this.membershipType = membershipType;
        this.borrowedBooks = new ArrayList<>();
    }


    public int getMemberID() { return memberID; }
    public void setMemberID(int memberID) { this.memberID = memberID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public boolean addBook(Book book) {
        if (membershipType.equalsIgnoreCase("Guest") && borrowedBooks.size() >= 1) {
            System.out.println("Guest members can only borrow 1 book at a time.");
            return false;
        }
    
        borrowedBooks.add(book);
        return true;
    }

    public void removeBook(Book book) {
        borrowedBooks.remove(book);
    }

    public double calculateLateFee(Book book, int daysOverdue) {
        return book.getPrice() * 0.01 * daysOverdue;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberID + ", Name: " + name + ", Membership: " + membershipType +
               ", Borrowed Books: " + borrowedBooks.size();
    }
}