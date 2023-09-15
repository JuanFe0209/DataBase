package org.example.repository.impl;
import org.example.conexion.ConexionBD;
import org.example.domain.models.Grades;
import org.example.domain.models.Students;
import org.example.domain.models.Subjects;
import org.example.domain.models.Teachers;
import org.example.mapping.dtos.GradesDto;
import org.example.mapping.mapper.GradesMapper;
import org.example.repository.Repository;

import javax.security.auth.Subject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradesRepositoryImpl implements Repository<GradesDto> {

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }
    private Grades buildObject(ResultSet resultSet) throws
            SQLException {
        Grades grades = new Grades();
        grades.setId_Grades(resultSet.getLong("id_grades"));
        grades.setCorte(resultSet.getString("corte"));

        Students students = new Students();
        students.setId_Students(resultSet.getLong("id_students"));
        students.setName(resultSet.getString("name"));
        students.setEmail(resultSet.getString("email"));
        students.setCareer(resultSet.getString("career"));
        students.setSemester(resultSet.getString("semester"));
        grades.setStudent(students);

        Subjects subject = new Subjects();
        subject.setId_Subjects(resultSet.getLong("id_subject"));
        subject.setName(resultSet.getString("name"));

        Teachers teacher = new Teachers();
        teacher.setId_Teachers(resultSet.getLong("id_teacher"));
        teacher.setName(resultSet.getString("name"));
        teacher.setEmail(resultSet.getString("email"));
        subject.setTeacher(teacher);

        grades.setSubject(subject);

        return grades;
    }

    @Override
    public List<GradesDto> list() {
        List<Grades> gradesList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT students.id_students ,students.name, students.email," +
                     " students.career, students.semester, subject.name, teachers.name, teachers.email, grades.corte FROM" +
                     " grades INNER JOIN students on grades.id_students=students.id_students INNER JOIN subject on " +
                     "grades.id_subject=subject.id_subject inner join teachers " +
                     "on subject.id_teacher=teachers.id_teacher;")) {
            while (resultSet.next()) {
                Grades grades = buildObject(resultSet);
                gradesList.add(grades);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradesMapper.mapFrom(gradesList);
    }

    @Override
    public GradesDto byId(Long id) {
        Grades grades = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT students.id_students ,students.name, students.email, students.career, " +
                        "students.semester, subject.name, teachers.name, teachers.email, grades.corte FROM grades " +
                        "INNER JOIN students on grades.id_students=students.id_students INNER JOIN subject on " +
                        "grades.id_subject=subject.id_subject inner join teachers on " +
                        "subject.id_teacher=teachers.id_teacher WHERE grades.id_grades = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                grades = buildObject(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradesMapper.mapFrom(grades);
    }
    @Override
    public void update(GradesDto grades) {
        String sql;
        if (grades.id_Grades() != null && grades.id_Grades() > 0) {
            sql = "UPDATE grades SET id_students=?, id_subject=? , corte=?  WHERE id_grades=?";
        } else {
            sql = "INSERT INTO grades (id_students, id,subject, semester, corte) VALUES(?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setLong(1, grades.student().getId_Students());
            stmt.setLong(2, grades.subject().getId_Subjects());
            stmt.setString(3, grades.corte());

            if (grades.id_Grades() != null && grades.id_Grades() > 0) {
                stmt.setLong(3, grades.id_Grades());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM gradess WHERE id_grades =?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}