package org.example.domain.models;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Grade {
    private Long id_Grades;
    private Student student;
    private Subject subject;
    private String corte;

}