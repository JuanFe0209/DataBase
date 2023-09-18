package org.example.services.impl;

import org.example.mapping.dtos.GradeDto;
import org.example.repository.impl.GradeRepositoryImpl;
import org.example.services.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    GradeRepositoryImpl repo = new GradeRepositoryImpl();
    @Override
    public List<GradeDto> list() {
        return repo.list();
    }

    @Override
    public GradeDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(GradeDto grades) {
        repo.update(grades);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}