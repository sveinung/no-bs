package nobs.book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(BookResource.BOOK_PATH)
public class BookResource {

    public static final String BOOK_PATH = "/book";
    public static final String ID_PATH = "/{id}";

    private BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GET
    @Path(ID_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public BookDTO getBook(@PathParam("id") int id) {
        Book book = bookRepository.getBook(new BookID(id));

        return new BookDTO(book);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookRepository.saveBook(bookDTO.transfer());

        return new BookDTO(book);
    }
}
