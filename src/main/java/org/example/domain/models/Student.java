package org.example.domain.models;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private Long id_Students;
    private String name;
    private String email;
    private String semester;
    private String career;

}

