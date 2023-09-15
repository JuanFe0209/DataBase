package org.example.mapping.mapper;

import org.example.domain.models.Subjects;
import org.example.mapping.dtos.SubjectsDto;

import java.util.List;

public class SubjectsMapper {
    public static SubjectsDto mapFrom(Subjects source){
        return new SubjectsDto(source.getId_Subjects(),
                source.getName(),
                source.getTeacher());
    }
    public static Subjects mapFrom(SubjectsDto source){
        return new Subjects(source.id_Subjects(),
                source.name(),
                source.teacher());
    }
    public static List<SubjectsDto> mapFrom(List<Subjects> sources){
        return sources.parallelStream().map(e->mapFrom(e)).toList();
    }
}
