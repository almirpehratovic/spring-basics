package org.infobip.spring.boot;

import org.infobip.spring.boot.config.Config;
import org.infobip.spring.boot.service.CinemaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CinemaService cinemaService) {
        return runner -> printDatabase(cinemaService);
    }

    private static void printDatabase(CinemaService cinemaService) {
        cinemaService.findAllMovies().forEach(System.out::println);
    }
}
