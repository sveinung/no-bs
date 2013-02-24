package nobs.library;

import nobs.book.BookID;
import nobs.book.BookURIBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private List<URI> books;

    public LibraryDTO(Library library, BookURIBuilder bookURIBuilder) {
        books = new ArrayList<>();
        for (BookID bookID : library.getBooks()) {
            books.add(bookURIBuilder.build(bookID));
        }
    }

    public List<URI> getBooks() {
        return books;
    }

    public void setBooks(List<URI> books) {
        this.books = books;
    }
}
