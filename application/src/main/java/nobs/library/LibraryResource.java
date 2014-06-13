package nobs.library;

import nobs.book.BookURIBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/library")
public class LibraryResource {

    private LibraryRepository libraryRepository;
    private BookURIBuilder bookURIBuilder;

    public LibraryResource(LibraryRepository libraryRepository, BookURIBuilder bookURIBuilder) {
        this.libraryRepository = libraryRepository;
        this.bookURIBuilder = bookURIBuilder;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LibraryDTO getLibrary() {
        Library library = libraryRepository.getLibrary();

        return new LibraryDTO(library, bookURIBuilder);
    }
}
