package nobs.book;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Component
public class BookURIBuilder {
    public URI build(BookID id) {
        return UriBuilder.fromPath(BookResource.BOOK_PATH)
                         .path(BookResource.ID_PATH)
                         .build(id.getValue());
    }
}
