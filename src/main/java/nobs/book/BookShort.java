package nobs.book;

public class BookShort {
    private final String title;
    private final BookID id;

    public BookShort(String title, BookID id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public BookID getId() {
        return id;
    }
}
