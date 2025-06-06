import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    public Book findBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void removeMember(int memberID) {
        members.removeIf(m -> m.getMemberID() == memberID);
    }

    public boolean borrowBook(int memberID, String isbn) {
        Member m = getMember(memberID);
        Book b = findBook(isbn);
        if (m != null && b != null && m.addBook(b)) {
            books.remove(b);
            return true;
        }
        return false;
    }

    public double returnBook(int memberID, String isbn, int daysOverdue) {
        Member m = getMember(memberID);
        if (m != null) {
            Book bookToReturn = null;
            for (Book b : m.getBorrowedBooks()) {
                if (b.getIsbn().equals(isbn)) {
                    bookToReturn = b;
                    break;
                }
            }
            if (bookToReturn != null) {
                m.removeBook(bookToReturn);
                addBook(bookToReturn);
                return m.calculateLateFee(bookToReturn, daysOverdue);
            }
        }
        return 0.0;
    }

    private Member getMember(int memberID) {
        for (Member m : members) {
            if (m.getMemberID() == memberID) return m;
        }
        return null;
    }
    public ArrayList<Book> listBooks() {
        return new ArrayList<>(books);
    }

    public ArrayList<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public Member findMember(int memberId) {
        for (Member m : members) {
            if (m.getMemberID() == memberId) {
                return m;
            }
        }
        return null;
    }
}