package com.example.movie_description.services;

import com.example.movie_description.models.Movie;
import com.example.movie_description.repositories.MovieRepository;
import org.apache.http.HttpException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GeminiService geminiService;

    public MovieService(
            MovieRepository movieRepository,
            GeminiService geminiService) {

        this.movieRepository = movieRepository;
        this.geminiService = geminiService;
    }

    // Add a movie and generate its description
    public Movie addMovie(Movie movie) throws HttpException, IOException {

        String description =
                geminiService.generateDescription(movie.getTitle());

        movie.setDescription(description);

        return movieRepository.save(movie);
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
