package org.example.mapping.mapper;

import org.example.domain.models.Grade;
import org.example.mapping.dtos.GradeDto;

import java.util.List;

public class GradeMapper {
    public static GradeDto mapFrom(Grade source) {
        return new GradeDto(source.getId_Grades(),
                source.getStudent(),
                source.getSubject(),
                source.getCorte());
    }

    public static Grade mapFrom(GradeDto source) {
        return new Grade(source.id_Grades(),
                source.student(),
                source.subject(),
                source.corte());
    }

    public static List<GradeDto> mapFrom(List<Grade> sources) {
        return sources.parallelStream().map(e -> mapFrom(e)).toList();
    }
}