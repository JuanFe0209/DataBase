package org.example.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Subject {
    private Long id_Subjects;
    private String name;
    private Teacher teacher;

}