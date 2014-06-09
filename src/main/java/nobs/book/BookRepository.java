package nobs.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookRepository {

    private final HashMap<Integer,Book> books;
    private int latestId;

    public BookRepository() {
        latestId = 5;
        books = new HashMap<Integer,Book>() {{
            put(1, new Book(new BookID(1), "John Steinbeck", "Of Mice and Men", "Novella"));
            put(2, new Book(new BookID(2), "Isaac Asimov", "The Last Question", "Science fiction"));
            put(3, new Book(new BookID(3), "Herman Melville", "Moby Dick", "Adventure"));
            put(4, new Book(new BookID(4), "Knut Hamsun", "Sult", "Novel"));
        }};
    }

    public List<BookShort> getBooks() {
        List<BookShort> bookSummaries = new ArrayList<>();
        for (Book book : books.values()) {
            bookSummaries.add(new BookShort(book.getTitle(), book.getId()));
        }

        return bookSummaries;
    }

    public Book getBook(BookID id) {
        return books.get(id.getValue());
    }

    public Book saveBook(Book book) {
        Book savedBook = new Book(new BookID(latestId), book.getAuthor(), book.getTitle(), book.getGenre());
        latestId++;

        books.put(latestId, savedBook);

        return savedBook;
    }
}
