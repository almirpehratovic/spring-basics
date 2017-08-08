package org.infobip.spring.ann.service;

import org.infobip.spring.ann.domain.Actor;
import org.infobip.spring.ann.domain.Movie;

import java.util.Set;

public interface CinemaService {
    Movie findMovieById(int id);
    Set<Movie> findAllMovies();
    Movie saveMovie(Movie movie);
    void deleteMovie(int id);

    Actor findActorById(int id);
    Set<Actor> findAllActors();
    Actor saveActor(Actor actor);
    void deleteActor(int id);
}
