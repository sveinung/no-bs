package nobs.library;

import nobs.book.Book;
import nobs.book.BookID;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<BookID> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(List<BookID> books) {
        this.books = books;
    }

    public List<BookID> getBooks() {
        return books;
    }
}
