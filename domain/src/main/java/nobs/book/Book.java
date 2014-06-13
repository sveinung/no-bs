package nobs.book;

public class Book {
    private BookID id;
    private final String author;
    private final String title;
    private final String genre;

    public Book() {
        this.author = null;
        this.title = null;
        this.genre = null;
    }

    public Book(BookID id, String author, String title, String genre) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public BookID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
