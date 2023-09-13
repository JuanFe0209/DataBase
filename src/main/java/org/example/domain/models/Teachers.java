package org.example.domain.models;

public class Teachers {
    private long id;
    private String name;
    private String email;

    public Teachers(long id, String name, String correo) {
        this.id = id;
        this.name = name;
        this.email = correo;
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

    @Override
    public String toString() {
        return "Profesores{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", correo='" + email + '\'' +
                '}';
    }
}
