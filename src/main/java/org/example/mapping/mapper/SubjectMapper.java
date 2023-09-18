package org.example.mapping.mapper;

import org.example.domain.models.Subject;
import org.example.mapping.dtos.SubjectDto;

import java.util.List;

public class SubjectMapper {
    public static SubjectDto mapFrom(Subject source){
        return new SubjectDto(source.getId_Subjects(),
                source.getName(),
                source.getTeacher());
    }
    public static Subject mapFrom(SubjectDto source){
        return new Subject(source.id_Subjects(),
                source.name(),
                source.teacher());
    }
    public static List<SubjectDto> mapFrom(List<Subject> sources){
        return sources.parallelStream().map(e->mapFrom(e)).toList();
    }
}
