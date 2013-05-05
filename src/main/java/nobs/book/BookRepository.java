package nobs.book;

public class BookRepository {

    public Book getBook(BookID id) {
        switch (id.getValue()) {
            case 1:
                return new Book("John Steinbeck", "Of Mice and Men");
            case 2:
                return new Book("Isaac Asimov", "The Last Question");
            case 3:
                return new Book("Moby Dick", "Herman Melville");
            case 4:
                return new Book("Sult", "Knut Hamsun");
            default:
                return new Book();
        }
    }
}
