package org.example.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Teacher {
    private Long id_Teachers;
    private String name;
    private String email;

}
