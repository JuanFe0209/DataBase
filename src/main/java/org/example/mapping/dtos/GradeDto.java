package org.example.mapping.dtos;

import org.example.domain.models.Student;
import org.example.domain.models.Subject;

public record GradeDto(Long id_Grades,
                       Student student,
                       Subject subject,
                       String corte){
}
