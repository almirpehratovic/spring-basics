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
    private int id;
    private String title;
    private int duration;
    private Set<Actor> actors;
}
