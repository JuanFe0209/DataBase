package org.example.mapping.mapper;

import org.example.domain.models.Teachers;
import org.example.mapping.dtos.TeachersDto;

import java.util.List;

public class TeachersMapper {
    public static TeachersDto mapFrom(Teachers source){
        return new TeachersDto(source.getId_Teachers(),
                source.getName(),
                source.getEmail());
    }
    public static Teachers mapFrom(TeachersDto source){
        return new Teachers(source.id_Teachers(),
                source.name(),
                source.email());
    }
    public static List<TeachersDto> mapFrom(List<Teachers>sources){
        return sources.parallelStream().map(e->mapFrom(e)).toList();
    }
}
