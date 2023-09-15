package org.example.domain.models;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Grades {
    private Long id_Grades;
    private Students student;
    private Subjects subject;
    private String corte;

}