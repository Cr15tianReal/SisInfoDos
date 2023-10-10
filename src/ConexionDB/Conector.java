
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
