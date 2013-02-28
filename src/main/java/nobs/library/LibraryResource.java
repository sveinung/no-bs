package nobs.library;

import nobs.book.BookURIBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/library")
public class LibraryResource {

    private LibraryRepository libraryRepository;
    private BookURIBuilder bookURIBuilder;
    private LibraryExcelMapper libraryExcelMapper;

    public LibraryResource(LibraryRepository libraryRepository, BookURIBuilder bookURIBuilder,
                           LibraryExcelMapper libraryExcelMapper) {

        this.libraryRepository = libraryRepository;
        this.bookURIBuilder = bookURIBuilder;
        this.libraryExcelMapper = libraryExcelMapper;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LibraryDTO getLibrary(@PathParam("id") int libraryId) {
        Library library = libraryRepository.getLibrary(libraryId);

        return new LibraryDTO(library, bookURIBuilder);
    }

    @GET
    @Path("/{id}/excel")
    @Produces("application/vnd.ms-excel")
    public Response exportToExcel(@PathParam("id") int libraryId) {
        Library library = libraryRepository.getLibrary(libraryId);

        return Response.ok()
                       .entity(libraryExcelMapper.toExcel(library))
                       .build();
    }

}
