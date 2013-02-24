package nobs.book;

public class BookRepository {

    public Book getBook(BookID id) {
        switch (id.getValue()) {
            case 1:
                return new Book("John Steinbeck", "Of Mice and Men");
            case 2:
                return new Book("Isaac Asimov", "The Last Question");
            default:
                return new Book();
        }
    }
}
