package org.example.services;

import org.example.mapping.dtos.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> listar();
    StudentDto porId(Long id);
    void guardar(StudentDto t);
    void eliminar(Long id);
}
