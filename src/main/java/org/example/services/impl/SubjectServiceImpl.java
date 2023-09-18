package org.example.services.impl;

import org.example.mapping.dtos.SubjectDto;
import org.example.repository.impl.SubjectRepositoryImpl;
import org.example.services.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    SubjectRepositoryImpl repo = new SubjectRepositoryImpl();

    @Override
    public List<SubjectDto> list() {
        return repo.list();
    }

    @Override
    public SubjectDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(SubjectDto subject) {
        repo.update(subject);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}