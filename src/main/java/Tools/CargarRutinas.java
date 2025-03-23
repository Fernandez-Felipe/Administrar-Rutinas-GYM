package Tools;

import Usuarios.RUTINAS;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CargarRutinas {

    int ID;
    RUTINAS rutinas;
    DefaultListModel<String> ListaDeRutinas;
    Connection Conn;

    public CargarRutinas(int ID, DefaultListModel<String> ListaDeRutinas,Connection Conn){

        this.ID = ID;
        this.ListaDeRutinas = ListaDeRutinas;
        this.Conn = Conn;

    }

    public void CargarRutinas() throws SQLException, IOException, ClassNotFoundException {

        GetData GD = new GetData();

        ResultSet rs = GD.ObtenerDatos(ID,Conn);
        DescerealizarRutinas DR = new DescerealizarRutinas();

        if(rs.next()){
            byte[] Rutinas = rs.getBytes("rutina");
            rutinas = DR.LeerBytesDeRutinas(Rutinas);
        }

        if(rutinas.getRutinas().isEmpty()){
            ListaDeRutinas.removeAllElements();
            ListaDeRutinas.addElement("No hay rutinas registradas");
        }else {
            ListaDeRutinas.removeAllElements();
            for(int i = 0; i < rutinas.getTitulos().size(); i++){
                ListaDeRutinas.addElement(rutinas.getTitulos().get(i));
            }

        }

    }

}
