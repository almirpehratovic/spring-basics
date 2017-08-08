package org.infobip.spring.ann.config;

import org.infobip.spring.ann.domain.Actor;
import org.infobip.spring.ann.domain.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "org.infobip.spring.ann")
public class Config {

    @Bean
    public Actor actor1(){
        return new Actor(1, "Brad", "Pitt");
    }

    @Bean(name="actor2")
    public Actor actor2(){
        return new Actor(1, "Edward", "Norton");
    }

    @Bean(name="movie1")
    public Movie movie1(){
        Set<Actor> actors = new HashSet<>();
        actors.add(actor1());
        return new Movie(1, "Zodiac", 157, actors);
    }

    @Bean(name="movie2")
    public Movie movie2(Set<Actor> actors){
        return new Movie(2, "Fight Club", 139, actors);
    }


}
