package org.example.services;

import org.example.mapping.dtos.GradeDto;

import java.util.List;

public interface GradeService {

    List<GradeDto> list();
    GradeDto byId(Long id);
    void update(GradeDto t);
    void delete(Long id);

}