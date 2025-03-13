package Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetData {

    public ResultSet ObtenerDatos(int ID, Connection Conn) throws SQLException {

        PreparedStatement PSTM = Conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
        PSTM.setInt(1,ID);

        return PSTM.executeQuery();

    }

}
