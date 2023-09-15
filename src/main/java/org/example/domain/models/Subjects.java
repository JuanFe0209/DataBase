package org.example.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Subjects {
    private Long id_Subjects;
    private String name;
    private Teachers teacher;

}