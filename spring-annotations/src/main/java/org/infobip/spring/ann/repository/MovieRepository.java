package org.infobip.spring.ann.repository;

import org.infobip.spring.ann.domain.Movie;

import java.util.Set;

public interface MovieRepository {
    Movie findById(int id);
    Set<Movie> findAll();
    Set<Movie> findByTitle(String title);

    Movie save(Movie movie);
    void delete(Movie movie);
}
