package nobs.library;

import nobs.book.BookID;
import nobs.book.BookShort;

import static java.util.Arrays.asList;

public class LibraryRepository {
    public Library getLibrary(int libraryId) {
        switch (libraryId) {
            case 1:
                return new Library(asList(new BookShort("Of Mice and Men", new BookID(1)),
                                          new BookShort("The Last Question", new BookID(2)),
                                          new BookShort("Moby Dick", new BookID(3)),
                                          new BookShort("Sult", new BookID(4))));
            case 2:
                return new Library(asList(new BookShort("Of Mice and Men", new BookID(1)),
                                          new BookShort("The Last Question", new BookID(2))));
            default:
                return new Library();
        }
    }
}
