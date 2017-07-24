package org.infobip.spring.boot.repository;


import org.infobip.spring.boot.domain.Actor;

import java.util.Set;

public interface ActorRepository {
    Actor findById(int id);
    Set<Actor> findAll();
    Set<Actor> findByFirstNameAndLastName(String firstName, String lastName);

    Actor save(Actor actor);
    void delete(Actor actor);
}
