package org.example.domain.models;

public class Grades {
    private long id;
    private Students student;
    private Subjects subject;
    private String corte;

    public Grades(long id, Students student, Subjects subject, String corte) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.corte = corte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", corte='" + corte + '\'' +
                '}';
    }
}

