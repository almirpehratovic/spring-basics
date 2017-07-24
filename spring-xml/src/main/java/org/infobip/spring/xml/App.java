package org.infobip.spring.xml;

import org.infobip.spring.xml.domain.Movie;
import org.infobip.spring.xml.service.CinemaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-config.xml");

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
