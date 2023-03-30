package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovies(@RequestBody Movie movie)
    {
        String add = movieService.addMovies(movie);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        String add = movieService.addDirector(director);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName,
                                                        @RequestParam("directorName")String directorName)
    {
        String addPair = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(addPair, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name)
    {
        Movie moviename = movieService.getMovieByName(name);
        return new ResponseEntity<>(moviename, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name)
    {
        Director directorName = movieService.getDirectorByName(name);
        return new ResponseEntity<>(directorName, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String director)
    {
        List<String> allmoviedirector = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(allmoviedirector, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies()
    {
        List<String> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName)
    {
        String delete = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(delete, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        String delete = movieService.deleteAllDirectors();
        return new ResponseEntity<>(delete, HttpStatus.CREATED);
    }
}
