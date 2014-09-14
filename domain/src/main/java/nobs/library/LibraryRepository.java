package nobs.library;

import nobs.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository {
    @Autowired
    private BookRepository bookRepository;

    public LibraryRepository()
    {
        System.out.println("--------- LibraryRepository");
    }

    public Library getLibrary() {
        return new Library(bookRepository.getBooks());
    }
}
