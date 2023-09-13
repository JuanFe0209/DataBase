package org.example.mapping.dtos;

import org.example.domain.models.Students;
import org.example.domain.models.Subjects;

public record GradesDto (long id,
                         Students student,
                         Subjects subject,
                         String corte){
}
