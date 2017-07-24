package org.infobip.spring.xml.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private int id;                 // unique identification
    private String firstName;
    private String lastName;
}
