package org.infobip.spring.ann.repository;

import org.infobip.spring.ann.domain.Actor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InMemoryActorRepository implements ActorRepository{
    private Set<Actor> actorsDatabase = new HashSet<Actor>();

    public Actor findById(int id) {
        return actorsDatabase.stream()
                .filter(actor -> actor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Set<Actor> findAll() {
        return actorsDatabase;
    }

    public Set<Actor> findByFirstNameAndLastName(String firstName, String lastName) {
        return actorsDatabase.stream()
                .filter(actor -> actor.getFirstName().equalsIgnoreCase(firstName) && actor.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toSet());
    }

    public Actor save(Actor actor) {
        actorsDatabase.add(actor);
        return actor;
    }

    public void delete(Actor actor) {
        actorsDatabase.remove(actor);
    }
}
