package nobs.library;

import nobs.book.Book;
import nobs.book.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private List<BookDTO> books;

    public LibraryDTO(Library library) {
        books = new ArrayList<>();
        for (Book book : library.getBooks()) {
            books.add(new BookDTO(book));
        }
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
