package org.example.mapping.dtos;

import org.example.domain.models.Students;
import org.example.domain.models.Subjects;

public record GradesDto (Long id_Grades,
                         Students student,
                         Subjects subject,
                         String corte){
}
