package org.infobip.spring.xml.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;                 // unique identifier
    private String title;           // original title
    private int duration;           // duration of movie in minutes
    private Set<Actor> actors;      // main set of actors
}
