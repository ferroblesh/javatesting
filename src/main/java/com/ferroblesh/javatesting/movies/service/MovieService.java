package com.ferroblesh.javatesting.movies.service;

import com.ferroblesh.javatesting.movies.data.MovieRepository;
import com.ferroblesh.javatesting.movies.model.Genre;
import com.ferroblesh.javatesting.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());

    }


    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name)).collect(Collectors.toList());
    }
}
