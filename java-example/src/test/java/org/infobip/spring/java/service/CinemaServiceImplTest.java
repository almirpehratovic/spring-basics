package org.infobip.spring.java.service;

import org.infobip.spring.java.domain.Actor;
import org.infobip.spring.java.domain.Movie;
import org.infobip.spring.java.repository.InMemoryActorRepository;
import org.infobip.spring.java.repository.InMemoryMovieRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by apehratovic on 7/19/17.
 */
public class CinemaServiceImplTest {
    private CinemaServiceImpl service;
    private Set<Movie> movies;
    private Set<Actor> actors;

    @Before
    public void setup() {
        service = new CinemaServiceImpl(new InMemoryMovieRepository(), new InMemoryActorRepository());

        movies = new HashSet<>();
        actors = new HashSet<>();

        Actor actor1 = new Actor(1, "Brad", "Pit");
        Actor actor2 = new Actor(2, "Edward", "Norton");

        Movie movie1 = new Movie(1, "Zodiac", 157, new HashSet<>());
        Movie movie2 = new Movie(2, "Fight Club", 139,  new HashSet<>());

        movie1.getActors().add(actor1);
        movie2.getActors().add(actor1);
        movie2.getActors().add(actor2);

        service.saveMovie(movie1);
        service.saveMovie(movie2);

        service.saveActor(actor1);
        service.saveActor(actor2);
    }

    @After
    public void destroy() {
        service.deleteMovie(1);
        service.deleteMovie(2);

        service.deleteActor(1);
        service.deleteActor(2);
    }

    @Test
    public void findMovieById() throws Exception {
        Movie movie = service.findMovieById(2);
        assertNotNull(movie);
        assertEquals(2, movie.getId());
        assertEquals(2, movie.getActors().size());
    }

    @Test
    public void findAllMovies() throws Exception {
        assertEquals(2, service.findAllMovies().size());
    }

    @Test
    public void saveMovie() throws Exception {
        service.saveMovie(new Movie(3, "Gori Vatra", 92, new HashSet<>()));
        assertEquals(3, service.findAllMovies().size());
    }

    @Test
    public void deleteMovie() throws Exception {
        service.deleteMovie(1);
        assertEquals(1, service.findAllMovies().size());
        service.deleteMovie(2);
        assertEquals(0, service.findAllMovies().size());
    }

    @Test
    public void findActorById() throws Exception {
        Actor actor = service.findActorById(1);
        assertNotNull(actor);
        assertEquals(1, actor.getId());
    }

    @Test
    public void findAllActors() throws Exception {
        assertEquals(2, service.findAllActors().size());
    }

    @Test
    public void saveActor() throws Exception {
        Actor actor3 = new Actor(3, "Emir", "Hadžihafizbegović");
        service.saveActor(actor3);
        assertEquals(3, service.findAllActors().size());
    }

    @Test
    public void deleteActor() throws Exception {
        service.deleteActor(1);
        assertEquals(1, service.findAllActors().size());
        service.deleteActor(2);
        assertEquals(0, service.findAllActors().size());
    }

}