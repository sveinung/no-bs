package nobs;

import com.sun.org.apache.bcel.internal.generic.NEW;
import nobs.book.BookRepository;
import nobs.book.BookResource;
import nobs.book.BookURIBuilder;
import nobs.library.LibraryExcelMapper;
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

        resources.add(new LibraryResource(new LibraryRepository(),
                                          new BookURIBuilder(),
                                          new LibraryExcelMapper(bookRepository)));

        resources.add(new BookResource(bookRepository));

        return resources;
    }
}
