package nobs.library;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/library")
public class LibraryResource {

    private LibraryRepository libraryRepository;

    public LibraryResource(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LibraryDTO getLibrary(@PathParam("id") int libraryId) {
        Library library = libraryRepository.getLibrary(libraryId);

        return new LibraryDTO(library);
    }
}
