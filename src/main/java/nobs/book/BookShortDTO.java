package nobs.book;

import java.net.URI;

public class BookShortDTO {
    private String title;
    private URI uri;

    public BookShortDTO(String title, URI uri) {
        this.title = title;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
