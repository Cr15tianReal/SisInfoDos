
package CristhianReal;

import ConexionDB.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgregarFruta {
    
    public boolean frutaExiste(String nombre) {
        String sql = "SELECT COUNT(*) FROM frutas WHERE nombre = ?";
        
        try (Connection conn = Conector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public void insertarFruta(ModeloFruta fruta) {
        Connection conn = null;
        try {
            conn = Conector.getConnection();
            if (frutaExiste(fruta.getNombre())) {
                System.out.println("La fruta ya existe en la base de datos.");
                return;
            }

            String sql = "INSERT INTO frutas (nombre, precio) VALUES (?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, fruta.getNombre());
                pstmt.setDouble(2, fruta.getPrecio());

                pstmt.executeUpdate();

                System.out.println("Fruta insertada con éxito.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
