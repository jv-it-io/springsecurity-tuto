package be.jvit.springSecurityDemo.controller;

import be.jvit.springSecurityDemo.domain.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jonathan Vandersmissen
 * @created 4/4/2021
 * @project springSecurityDemo
 */
@RestController
@RequestMapping("management/api/v1/movies")
public class MovieManagementController {

    private static final List<Movie> movies = Arrays.asList(
            new Movie(1, "Tenet"),
            new Movie(2, "Interstellar"),
            new Movie(3, "The Dark Knight Rises")
    );

    @GetMapping
    public List<Movie> getAllMovies(){
        return movies;
    }

    @PostMapping
    public void registerNewMovie(@RequestBody Movie movie){
        System.out.println(movie);
    }

    @DeleteMapping(path = "{movieId}")
    public void deleteMovie(@PathVariable("movieId") Integer movieId){
        System.out.println(movieId);
    }

    @PutMapping(path = "{movieId}")
    public void updateMovie(@PathVariable("movieId") Integer movieId,@RequestBody Movie movie){
        System.out.println(String.format("%s %s", movieId, movie));
    }
}
