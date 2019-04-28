package com.ferroblesh.javatesting.movies.service;

import com.ferroblesh.javatesting.movies.data.MovieRepository;
import com.ferroblesh.javatesting.movies.model.Genre;
import com.ferroblesh.javatesting.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Knight",152,Genre.ACTION),
                        new Movie(2,"Memento",113,Genre.THRILLER),
                        new Movie(3,"There's Something About Mary",119,Genre.COMEDY),
                        new Movie(4,"Super 8",112,Genre.THRILLER),
                        new Movie(5,"Scream",111,Genre.HORROR),
                        new Movie(6,"Home Alone",103,Genre.COMEDY),
                        new Movie(7,"Matrix",136,Genre.ACTION),
                        new Movie(8,"Super Man",112,Genre.ACTION)

                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {



        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2,3,4,5,6)));

    }

    @Test
    public void return_movies_by_name() {

        Collection<Movie> movies = movieService.findMoviesByName("super");

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(4,8)));
    }

    @Test
    public void return_movies_by_name_and_length() {
        Movie movie = new Movie("super",119,null);
        Collection<Movie> movies =  movieService.findMoviesByTemplate(movie);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(4,8)));
    }

    @Test
    public void return_movies_by_length_and_genre() {
        assertThat(
                getMovieIds(movieService.findMoviesByTemplate(
                        new Movie(null,150,Genre.ACTION))),
                CoreMatchers.is(Arrays.asList(7,8))
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void return_movies_by_negative_length() {
        movieService.findMoviesByTemplate(new Movie(null,-119,Genre.ACTION));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}