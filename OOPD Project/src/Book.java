public class Book {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private double price;

    public Book() {
        this.isbn = "";
        this.title = "";
        this.author = "";
        this.category = "";
        this.price = 0.0;
    }

    public Book(String isbn, String title, String author, String category, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author +
               ", Category: " + category + ", Price: $" + price;
    }
}
