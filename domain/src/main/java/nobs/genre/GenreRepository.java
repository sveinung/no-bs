package nobs.genre;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenreRepository {
    public List<Genre> getGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(new Genre("Adventure"));
        genres.add(new Genre("Science fiction"));
        genres.add(new Genre("Novel"));
        genres.add(new Genre("Novella"));
        genres.add(new Genre("Crime novel"));
        genres.add(new Genre("Picaresco"));
        return genres;
    }
}
