package org.example.mapping.dtos;

import org.example.domain.models.Teachers;

public record SubjectDto(long id,
                         String name,
                         Teachers teacher){

}
