package org.example;

import org.example.conexion.ConexionBD;
import org.example.domain.models.Producto;
import org.example.repository.Repository;
import org.example.repository.impl.Implement;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universidad";
        String user = "root";
        String password = "admin";
        try (Connection conn = DriverManager.getConnection(url, user,
                password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM profesores");
             ){
            while (resultSet.next()) {
                System.out.print(resultSet.getLong("id"));
                System.out.print("|");
            }System.out.print(resultSet.getString("nombre"));
            System.out.print("|");
            System.out.print(resultSet.getString("correo"));

        } catch (SQLException e) {
            e.printStackTrace();
        }{
            try(Connection conn = ConexionBD.getInstance()){
                Repository<Producto> repository = new Repository();
                listProducts(repository);
                getProductById(repository);
                deleteProduct(repository);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
