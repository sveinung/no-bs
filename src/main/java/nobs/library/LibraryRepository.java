package nobs.library;

import nobs.book.Book;

import java.util.Arrays;

public class LibraryRepository {
    public Library getLibrary(int libraryId) {
        switch (libraryId) {
            case 1:
                return new Library(Arrays.asList(new Book("John Steinbeck", "Of Mice and Men")));
            case 2:
                return new Library(Arrays.asList(new Book("John Steinbeck", "Of Mice and Men"),
                                                 new Book("Isaac Asimov", "The Last Question")));
            default:
                return new Library();
        }
    }
}
