package org.example.domain.models;

public class Students {
    private long id;
    private String name;
    private String email;
    private String semester;
    private String career;

    public Students(long id, String name, String email, String semester, String career) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.semester = semester;
        this.career = career;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", semester='" + semester + '\'' +
                ", career='" + career + '\'' +
                '}';
    }
}

