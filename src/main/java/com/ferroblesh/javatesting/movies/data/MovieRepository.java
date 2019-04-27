package com.ferroblesh.javatesting.movies.data;

import com.ferroblesh.javatesting.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
