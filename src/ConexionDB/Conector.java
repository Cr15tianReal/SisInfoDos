/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private static final String URL = "jdbc:sqlite:frutasdb.db";

    public static Connection getConnection() {
        try {
            System.out.println("Conexion exitosa");
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar", e);
        }
    }
}
