package nobs.library;

import nobs.book.BookShort;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<BookShort> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(List<BookShort> books) {
        this.books = books;
    }

    public List<BookShort> getBooks() {
        return books;
    }
}
