package org.example.repository.impl;
import org.example.conexion.ConexionBD;
import org.example.domain.models.Grade;
import org.example.domain.models.Student;
import org.example.domain.models.Subject;
import org.example.domain.models.Teacher;
import org.example.mapping.dtos.GradeDto;
import org.example.mapping.mapper.GradeMapper;
import org.example.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryImpl implements Repository<GradeDto> {

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }
    private Grade buildObject(ResultSet resultSet) throws
            SQLException {
        Grade grades = new Grade();
        grades.setId_Grades(resultSet.getLong("id_grades"));
        grades.setCorte(resultSet.getString("corte"));

        Student students = new Student();
        students.setId_Students(resultSet.getLong("id_students"));
        students.setName(resultSet.getString("name"));
        students.setEmail(resultSet.getString("email"));
        students.setCareer(resultSet.getString("career"));
        students.setSemester(resultSet.getString("semester"));
        grades.setStudent(students);

        Subject subject = new Subject();
        subject.setId_Subjects(resultSet.getLong("id_subject"));
        subject.setName(resultSet.getString("name"));

        Teacher teacher = new Teacher();
        teacher.setId_Teachers(resultSet.getLong("id_teacher"));
        teacher.setName(resultSet.getString("name"));
        teacher.setEmail(resultSet.getString("email"));
        subject.setTeacher(teacher);

        grades.setSubject(subject);

        return grades;
    }

    @Override
    public List<GradeDto> list() {
        List<Grade> gradesList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT students.id_students ,students.name, students.email," +
                     " students.career, students.semester, subject.name, teachers.name, teachers.email, grades.corte FROM" +
                     " grades INNER JOIN students on grades.id_students=students.id_students INNER JOIN subject on " +
                     "grades.id_subject=subject.id_subject inner join teachers " +
                     "on subject.id_teacher=teachers.id_teacher;")) {
            while (resultSet.next()) {
                Grade grades = buildObject(resultSet);
                gradesList.add(grades);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GradeMapper.mapFrom(gradesList);
    }

    @Override
    public GradeDto byId(Long id) {
        Grade grades = null;
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
        return GradeMapper.mapFrom(grades);
    }
    @Override
    public void update(GradeDto grades) {
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