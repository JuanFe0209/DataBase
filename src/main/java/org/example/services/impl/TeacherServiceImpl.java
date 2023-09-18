package org.example.services.impl;


import org.example.mapping.dtos.TeacherDto;
import org.example.repository.impl.TeacherRepositoryImpl;
import org.example.services.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    TeacherRepositoryImpl repo =  new TeacherRepositoryImpl();
    @Override
    public List<TeacherDto> list() {
        return repo.list();
    }

    @Override
    public TeacherDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(TeacherDto teacher) {
        repo.update(teacher);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}