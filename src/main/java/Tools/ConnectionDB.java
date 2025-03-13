package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String DB_URL = "jdbc:derby:./database/DBUsuarios";
    private Connection conn;

    public ConnectionDB(){
        Conectar();
    }

    public void Conectar(){
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DB_URL);
                System.out.println("✅ Conectado a la base de datos Java DB (Derby)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("✅ Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
