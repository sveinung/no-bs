package nobs.library;

import nobs.book.BookShort;
import nobs.book.BookShortDTO;
import nobs.book.BookURIBuilder;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private List<BookShortDTO> books;

    public LibraryDTO(Library library, BookURIBuilder bookURIBuilder) {
        books = new ArrayList<>();
        for (BookShort book : library.getBooks()) {
            books.add(new BookShortDTO(book.getTitle(), bookURIBuilder.build(book.getId())));
        }
    }

    public List<BookShortDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookShortDTO> books) {
        this.books = books;
    }
}
