package org.example.services;

import org.example.mapping.dtos.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> list();
    TeacherDto byId(Long id);
    void update(TeacherDto t);
    void delete(Long id);

}