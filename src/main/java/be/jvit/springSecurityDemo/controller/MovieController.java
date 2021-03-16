package be.jvit.springSecurityDemo.controller;

import be.jvit.springSecurityDemo.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private static final List<Movie> movies = Arrays.asList(
            new Movie(1, "Tenet"),
            new Movie(2, "Interstellar"),
            new Movie(3, "The Dark Knight Rises")
    );

    @GetMapping(path = "{movieId}")
    public Movie getStudent(@PathVariable("movieId") Integer id){
        return movies.stream()
                .filter(student -> id.equals(student.getMovieId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Movie " + id + " doesn't exist"));
    }
}
