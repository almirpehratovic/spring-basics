package org.infobip.spring.java.repository;

import org.infobip.spring.java.domain.Actor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class InMemoryActorRepositoryTest {

    private InMemoryActorRepository repository;
    private Actor actor;

    @Before
    public void setup() {
        repository = new InMemoryActorRepository();
        actor = new Actor(1, "Brad", "Pitt");
        repository.save(actor);
    }

    @After
    public void destroy(){
        repository.delete(actor);
    }

    @Test
    public void findById() throws Exception {
        Actor retreived = repository.findById(1);
        assertNotNull(retreived);
        assertEquals(actor, retreived);

        assertNull(repository.findById(1000));
    }

    @Test
    public void findAll() throws Exception {
        assertEquals(1, repository.findAll().size());
    }

    @Test
    public void findByFirstNameAndLastName() throws Exception {
        Set<Actor> retreived = repository.findByFirstNameAndLastName(actor.getFirstName(), actor.getLastName());
        assertNotEquals(0, retreived.size());
        assertTrue(retreived.contains(actor));
    }

    @Test
    public void save() throws Exception {
        Actor newActor = repository.save(new Actor(2, "Scarlett", "Johansson"));
        Assert.assertEquals(newActor, repository.findById(2));
        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void delete() throws Exception {
        repository.delete(actor);
        assertEquals(0, repository.findAll().size());
    }

}