package Main;

import DataBase.ConnectioDB;
import DataBase.Statements;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static InterfazRutinas Window = new InterfazRutinas();
    public static ConnectioDB Conectar = new ConnectioDB();

    public static void main(String[] args) throws SQLException {


        Conectar.Conectar();

        Window.setVisible(true);

    }
}
