package nobs.library;

import nobs.book.BookID;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private List<Integer> books;

    public LibraryDTO(Library library) {
        books = new ArrayList<>();
        for (BookID bookID : library.getBooks()) {
            books.add(bookID.getValue());
        }
    }

    public List<Integer> getBooks() {
        return books;
    }

    public void setBooks(List<Integer> books) {
        this.books = books;
    }
}
