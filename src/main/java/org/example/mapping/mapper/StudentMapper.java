package org.example.mapping.mapper;

import org.example.domain.models.Student;
import org.example.mapping.dtos.StudentDto;

import java.util.List;

public class StudentMapper {
    public static StudentDto mapFrom(Student source){
        return new StudentDto(source.getId_Students(),
                source.getName(),
                source.getEmail(),
                source.getSemester(),
                source.getCareer());
    }
    public static Student mapFrom(StudentDto source){
        return new Student(source.id_Students(),
                source.name(),
                source.email(),
                source.semester(),
                source.career());
    }
    public static List <StudentDto> mapFrom(List<Student> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
