package com.ferroblesh.javatesting.movies.service;

import com.ferroblesh.javatesting.movies.data.MovieRepository;
import com.ferroblesh.javatesting.movies.model.Genre;
import com.ferroblesh.javatesting.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    @Test
    public void return_movies_by_genre() {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Knight",12,Genre.ACTION),
                        new Movie(2,"Memento",12,Genre.THRILLER),
                        new Movie(3,"There's Something About Mary",12,Genre.COMEDY),
                        new Movie(4,"Super 8",12,Genre.THRILLER),
                        new Movie(5,"Scream",12,Genre.HORROR),
                        new Movie(6,"Home Alone",12,Genre.COMEDY),
                        new Movie(7,"Matrix",12,Genre.ACTION)

                )
        );

        MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> movieIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        assertThat(movieIds, CoreMatchers.is(Arrays.asList(3,6)));
    }
}