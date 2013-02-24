package nobs.library;

import nobs.book.BookID;

import static java.util.Arrays.asList;

public class LibraryRepository {
    public Library getLibrary(int libraryId) {
        switch (libraryId) {
            case 1:
                return new Library(asList(new BookID(1)));
            case 2:
                return new Library(asList(new BookID(1),
                                          new BookID(2)));
            default:
                return new Library();
        }
    }
}
