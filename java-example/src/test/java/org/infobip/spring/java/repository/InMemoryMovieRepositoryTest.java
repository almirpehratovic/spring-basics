package org.infobip.spring.java.repository;

import org.infobip.spring.java.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by apehratovic on 7/19/17.
 */
public class InMemoryMovieRepositoryTest {

    private InMemoryMovieRepository repository;
    private Movie movie;

    @Before
    public void setup() {
        repository = new InMemoryMovieRepository();
        movie = new Movie(1, "Fight Club", 139, null);
        repository.save(movie);
    }

    @After
    public void destroy() {
        repository.delete(movie);
    }

    @Test
    public void findById() throws Exception {
        Movie retreived = repository.findById(1);
        assertNotNull(retreived);
        assertEquals(movie, retreived);

        assertNull(repository.findById(1000));
    }

    @Test
    public void findAll() throws Exception {
        assertEquals(1, repository.findAll().size());
    }

    @Test
    public void findByTitle() throws Exception {
        Set<Movie> retreived = repository.findByTitle(movie.getTitle().toLowerCase());
        assertTrue(retreived.contains(movie));
    }

    @Test
    public void save() throws Exception {
        Movie newMovie = new Movie(2, "Requiem For a Dream", 102, null);
        repository.save(newMovie);
        assertEquals(2, repository.findAll().size());
        Assert.assertEquals(newMovie, repository.findById(2));
    }

    @Test
    public void delete() throws Exception {
        repository.delete(movie);
        assertEquals(0, repository.findAll().size());
    }

}