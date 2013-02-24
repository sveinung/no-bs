package nobs.book;

public class Book {
    private final String author;
    private final String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book() {
        this.author = null;
        this.title = null;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
