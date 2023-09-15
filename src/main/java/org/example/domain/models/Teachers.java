package org.example.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Teachers {
    private Long id_Teachers;
    private String name;
    private String email;

}
