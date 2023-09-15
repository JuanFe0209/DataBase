package org.example.repository.impl;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Teachers;
import org.example.mapping.dtos.TeachersDto;
import org.example.mapping.mapper.TeachersMapper;
import org.example.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeachersRepositoryImpl implements Repository<TeachersDto> {
    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }

    private Teachers buildObject(ResultSet resultSet) throws
            SQLException {
        Teachers teacher = new Teachers();
        teacher.setId_Teachers(resultSet.getLong("id_teacher"));
        teacher.setName(resultSet.getString("name"));
        teacher.setEmail(resultSet.getString("email"));

        return teacher;
    }

    @Override
    public List<TeachersDto> list() {
        List<Teachers> teacherList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from teachers")) {
            while (resultSet.next()) {
                Teachers teacher = buildObject(resultSet);
                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TeachersMapper.mapFrom(teacherList);
    }

    @Override
    public TeachersDto byId(Long id) {
        Teachers teacher = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM teachers WHERE id_teachers =?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                teacher = buildObject(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TeachersMapper.mapFrom(teacher);
    }

    @Override
    public void update(TeachersDto teacher) {
        String sql;
        if (teacher.id_Teachers() != null && teacher.id_Teachers() > 0) {
            sql = "UPDATE teachers SET name=?, email=? WHERE id_teacher=?";
        } else {
            sql = "INSERT INTO teachers (name, email) VALUES(?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, teacher.name());
            stmt.setString(2, teacher.email());

            if (teacher.id_Teachers() != null && teacher.id_Teachers() > 0) {
                stmt.setLong(3, teacher.id_Teachers());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM teachers WHERE id_teachers =?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
