package org.infobip.spring.xml.repository;

import org.infobip.spring.xml.domain.Movie;

import java.util.Set;

public interface MovieRepository {
    Movie findById(int id);
    Set<Movie> findAll();
    Set<Movie> findByTitle(String title);

    Movie save(Movie movie);
    void delete(Movie movie);
}
