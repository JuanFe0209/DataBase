package org.example.repository.impl;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Students;
import org.example.mapping.dtos.StudentsDto;
import org.example.mapping.mapper.StudentsMapper;
import org.example.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepositoryImpl implements Repository<StudentsDto> {
    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }
    private Students createStudent(ResultSet rs) throws SQLException {
        Students student = new Students();
        student.setId_Students(rs.getLong("id_student"));
        student.setName(rs.getString("nombre"));
        student.setEmail(rs.getString("email"));
        student.setCareer(rs.getString("career"));
        student.setSemester(rs.getString("semester"));
        return student;
    }
    @Override
    public List<StudentsDto> list() {
        List<Students> studentList = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from student")) {
            while (resultSet.next()) {
                Students student = createStudent(resultSet);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return StudentsMapper.mapFrom(studentList);
    }

    @Override
    public StudentsDto byId(Long id) {
        Students student = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM student WHERE id_student=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = createStudent(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return StudentsMapper.mapFrom(student);
    }

    @Override
    public void update(StudentsDto student) {
        String sql;
        if (student.id_Students() != null && student.id_Students()>0) {
            sql = "UPDATE student SET name=?, career=?, email=?, semester=? WHERE id_student=?";
        } else {
            sql = "INSERT INTO student (name, career, email, semester) VALUES(?,?,?,?)";
        }
        try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, student.name());
            stmt.setString(2, student.career());

            if (student.id_Students() != null && student.id_Students() > 0) {
                stmt.setString(3, student.email());
                stmt.setLong(4, student.id_Students());
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM student WHERE id_student =?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}