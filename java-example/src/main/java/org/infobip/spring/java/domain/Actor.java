package org.infobip.spring.java.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private int id;                 // unique identification
    private String firstName;
    private String lastName;
}
