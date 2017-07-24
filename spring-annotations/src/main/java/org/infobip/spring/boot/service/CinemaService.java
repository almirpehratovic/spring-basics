package org.infobip.spring.boot.service;



import org.infobip.spring.boot.domain.Actor;
import org.infobip.spring.boot.domain.Movie;

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