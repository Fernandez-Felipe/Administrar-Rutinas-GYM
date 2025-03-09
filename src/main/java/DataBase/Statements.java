package DataBase;

import java.sql.*;

public class Statements {
    Statement pst;

    public ResultSet GetData(Connection conn, String SQL) throws SQLException {

        pst = conn.createStatement();

        return pst.executeQuery(SQL);

    }

    public void InsertData(Connection conn, String SQL) throws SQLException {

        Statement statement = pst = conn.createStatement();

        pst.executeUpdate(SQL);

    }

}
