package nobs;

import nobs.book.BookRepository;
import nobs.book.BookResource;
import nobs.book.BookURIBuilder;
import nobs.genre.GenreRepository;
import nobs.genre.GenreResource;
import nobs.library.LibraryRepository;
import nobs.library.LibraryResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class MyApplication extends Application {

    @Override
    public Set<Object> getSingletons() {
        HashSet<Object> resources = new HashSet<>();

        BookRepository bookRepository = new BookRepository();

        resources.add(new LibraryResource(new LibraryRepository(bookRepository),
                                          new BookURIBuilder()));

        resources.add(new BookResource(bookRepository));

        resources.add(new GenreResource(new GenreRepository()));

        return resources;
    }
}
