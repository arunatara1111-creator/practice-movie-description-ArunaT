package com.example.movie_description.controllers;

import com.example.movie_description.models.Movie;
import com.example.movie_description.services.MovieService;

import jakarta.validation.Valid;
import org.apache.http.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // POST: Add a movie
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addMovie(@Valid @RequestBody Movie movie) throws HttpException, IOException {
        return movieService.addMovie(movie);
    }

    // GET: Get all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}