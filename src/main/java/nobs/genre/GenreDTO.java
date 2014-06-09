package nobs.genre;

public class GenreDTO {
    private String name;

    public GenreDTO(Genre genre) {
        name = genre.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
