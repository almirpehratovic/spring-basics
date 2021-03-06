package org.infobip.spring.ann;

import org.infobip.spring.ann.config.Config;
import org.infobip.spring.ann.domain.Movie;
import org.infobip.spring.ann.service.CinemaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        CinemaService cinemaService = ctx.getBean(CinemaService.class);
        Movie movie1 = ctx.getBean("movie1", Movie.class);
        Movie movie2 = ctx.getBean("movie2", Movie.class);
        cinemaService.saveMovie(movie1);
        cinemaService.saveMovie(movie2);

        printDatabase(cinemaService);

    }

    private static void printDatabase(CinemaService cinemaService) {
        cinemaService.findAllMovies().forEach(System.out::println);
    }
}
