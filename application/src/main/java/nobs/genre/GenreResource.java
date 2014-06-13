package nobs.genre;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/genre")
public class GenreResource {
    private GenreRepository genreRepository;

    public GenreResource(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GenreDTO> getGenres() {
        List<Genre> genres = this.genreRepository.getGenres();

        ArrayList<GenreDTO> genreDTOs = new ArrayList<>();
        for (Genre genre : genres) {
            genreDTOs.add(new GenreDTO(genre));
        }

        return genreDTOs;
    }
}
