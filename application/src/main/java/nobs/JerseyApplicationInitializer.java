package nobs;

import nobs.book.BookRepository;
import nobs.book.BookResource;
import nobs.book.BookURIBuilder;
import nobs.genre.GenreRepository;
import nobs.genre.GenreResource;
import nobs.library.LibraryRepository;
import nobs.library.LibraryResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.HashMap;

public class JerseyApplicationInitializer extends WebAppInitializer
{
    @Override
    public void initialize(ServletContext servletContext)
    {
        ServletRegistration.Dynamic jersey = servletContext.addServlet(
                "jersey",
                new ServletContainer(createJerseyResourceConfig()));
        jersey.addMapping("/rest/*");

        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        jersey.setInitParameters(initParameters);
    }

    private ResourceConfig createJerseyResourceConfig()
    {
        ResourceConfig resourceConfig = new ResourceConfig();

        BookRepository bookRepository = new BookRepository();

        LibraryResource libraryResource = new LibraryResource(
                new LibraryRepository(bookRepository),
                new BookURIBuilder());

        BookResource bookResource = new BookResource(bookRepository);

        GenreResource genreResource = new GenreResource(new GenreRepository());

        resourceConfig.registerInstances(
                libraryResource,
                bookResource,
                genreResource
        );

        return resourceConfig;
    }
}
