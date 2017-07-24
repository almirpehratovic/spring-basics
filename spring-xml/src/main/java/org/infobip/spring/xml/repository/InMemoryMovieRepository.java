package org.infobip.spring.xml.repository;

import org.infobip.spring.xml.domain.Movie;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryMovieRepository implements MovieRepository {
    private Set<Movie> movieDatabase = new HashSet<>();


    @Override
    public Movie findById(int id) {
        return movieDatabase.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Movie> findAll() {
        return movieDatabase;
    }

    @Override
    public Set<Movie> findByTitle(String title) {
        return movieDatabase.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toSet());
    }

    @Override
    public Movie save(Movie movie) {
        movieDatabase.add(movie);
        return movie;
    }

    @Override
    public void delete(Movie movie) {
        movieDatabase.remove(movie);
    }
}
