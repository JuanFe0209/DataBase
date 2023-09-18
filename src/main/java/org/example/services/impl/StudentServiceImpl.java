package org.example.services.impl;

import org.example.mapping.dtos.StudentDto;
import org.example.repository.impl.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentsService {
    private final StudentRepositoryImpl repository;

    public StudentServiceImpl(StudentRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentDto> listar() {
        return repository.list();
    }

    @Override
    public StudentDto porId(Long id) {
        return repository.byId(id);
    }

    @Override
    public void guardar(StudentDto t) {
        repository.update(t);
    }

    @Override
    public void eliminar(Long id) {
        repository.delete(id);
    }
}
