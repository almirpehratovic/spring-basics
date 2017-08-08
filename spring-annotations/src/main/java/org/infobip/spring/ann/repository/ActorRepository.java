package org.infobip.spring.ann.repository;


import org.infobip.spring.ann.domain.Actor;

import java.util.Set;

public interface ActorRepository {
    Actor findById(int id);
    Set<Actor> findAll();
    Set<Actor> findByFirstNameAndLastName(String firstName, String lastName);

    Actor save(Actor actor);
    void delete(Actor actor);
}
