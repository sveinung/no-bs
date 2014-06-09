package nobs.library;

import nobs.book.BookRepository;

public class LibraryRepository {
    private BookRepository bookRepository;

    public LibraryRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Library getLibrary() {
        return new Library(bookRepository.getBooks());
    }
}
