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

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        Collection<Movie> movies = movieRepository.findAll();
        if(template.getMinutes() < 0)
            throw new IllegalArgumentException("Negative value for minutes is not allowed");
        else {
            movies = movies.stream()
                    .filter(movie -> movie.getMinutes() <= template.getMinutes()).collect(Collectors.toList());
        }
        if(template.getName() != null && template.getName().length() > 0) {
            movies = movies.stream()
                    .filter(movie -> movie.getName().toLowerCase().contains(template.getName())).collect(Collectors.toList());
        }
        if(template.getGenre() != null) {
            movies = movies.stream()
                    .filter(movie -> template.getGenre().toString().equals(movie.getGenre().toString())).collect(Collectors.toList());
        }

        return movies;
    }
}
