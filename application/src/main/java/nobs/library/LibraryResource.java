package nobs.library;

import nobs.book.BookURIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/library")
public class LibraryResource {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookURIBuilder bookURIBuilder;

    public LibraryResource()
    {
        System.out.println("----- LibraryResource");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LibraryDTO getLibrary() {
        Library library = libraryRepository.getLibrary();

        return new LibraryDTO(library, bookURIBuilder);
    }
}
