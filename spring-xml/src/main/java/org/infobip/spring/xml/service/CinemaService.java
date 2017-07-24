package org.infobip.spring.xml.service;



import org.infobip.spring.xml.domain.Actor;
import org.infobip.spring.xml.domain.Movie;

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
