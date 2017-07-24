package org.infobip.spring.boot.config;

import org.infobip.spring.boot.domain.Actor;
import org.infobip.spring.boot.domain.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "org.infobip.spring.boot")
public class Config {

    @Bean(name="actor1")
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

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:h2:~/cinema", "sa", "");
        dataSource.setDriverClassName("org.h2.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DatabasePopulator databasePopulator() {
        return new ResourceDatabasePopulator(new ClassPathResource("schema.sql"), new ClassPathResource("data.sql"));
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource, DatabasePopulator databasePopulator) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator);
        initializer.setEnabled(true);
        return initializer;
    }

}
