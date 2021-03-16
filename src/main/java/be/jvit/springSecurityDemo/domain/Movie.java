package be.jvit.springSecurityDemo.domain;

public class Movie{
    private final Integer movieId;
    private final String movieName;


    public Movie(Integer movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }
}
