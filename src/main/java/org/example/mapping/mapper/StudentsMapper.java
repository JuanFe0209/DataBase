package org.example.mapping.mapper;

import org.example.domain.models.Students;
import org.example.mapping.dtos.StudentsDto;

import java.util.List;

public class StudentsMapper {
    public static StudentsDto mapFrom(Students source){
        return new StudentsDto(source.getId_Students(),
                source.getName(),
                source.getEmail(),
                source.getSemester(),
                source.getCareer());
    }
    public static Students mapFrom(StudentsDto source){
        return new Students(source.id_Students(),
                source.name(),
                source.email(),
                source.semester(),
                source.career());
    }
    public static List <StudentsDto> mapFrom(List<Students> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
