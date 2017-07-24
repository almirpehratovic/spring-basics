package org.infobip.spring.java;

import org.infobip.spring.java.domain.Actor;
import org.infobip.spring.java.domain.Movie;
import org.infobip.spring.java.repository.InMemoryActorRepository;
import org.infobip.spring.java.repository.InMemoryMovieRepository;
import org.infobip.spring.java.repository.MovieRepository;
import org.infobip.spring.java.repository.ActorRepository;
import org.infobip.spring.java.service.CinemaService;
import org.infobip.spring.java.service.CinemaServiceImpl;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        ActorRepository actorRepository = new InMemoryActorRepository();
        MovieRepository movieRepository = new InMemoryMovieRepository();

        CinemaService cinemaService = new CinemaServiceImpl(movieRepository, actorRepository);
        populateDatabase(cinemaService);
        printDatabase(cinemaService);

    }

    private static void populateDatabase(CinemaService cinemaService) {
        Actor actor1 = new Actor(1, "Brad", "Pit");
        Actor actor2 = new Actor(2, "Edward", "Norton");

        Movie movie1 = new Movie(1, "Zodiac", 157, new HashSet<>());
        Movie movie2 = new Movie(2, "Fight Club", 139,  new HashSet<>());

        movie1.getActors().add(actor1);
        movie2.getActors().add(actor1);
        movie2.getActors().add(actor2);

        cinemaService.saveMovie(movie1);
        cinemaService.saveMovie(movie2);

        cinemaService.saveActor(actor1);
        cinemaService.saveActor(actor2);
    }

    private static void printDatabase(CinemaService cinemaService) {
        cinemaService.findAllMovies().forEach(System.out::println);
    }
}
