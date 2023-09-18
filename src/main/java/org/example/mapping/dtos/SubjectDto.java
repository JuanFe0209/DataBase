package org.example.mapping.dtos;

import org.example.domain.models.Teacher;

public record SubjectDto(Long id_Subjects,
                         String name,
                         Teacher teacher){

}
