package org.example;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Producto;
import org.example.repository.Repository;
import org.example.repository.impl.Implement;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url, user,
                password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM docentes");
        ) {
            System.out.println("docentes: ");
            while (resultSet.next()) {

                System.out.print("id_Grades: "+resultSet.getInt("id"));
                System.out.print("\n");
                System.out.print(resultSet.getString("nombre"));
                System.out.print("\n");
                System.out.print(resultSet.getString("correo"));
                System.out.print("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}