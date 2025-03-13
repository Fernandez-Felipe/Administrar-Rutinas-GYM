package Usuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.ArrayList;

public class RUTINAS implements Serializable {

    private final ArrayList<DefaultTableModel> runinas;

    public RUTINAS(ArrayList<DefaultTableModel> rutinas){
        this.runinas = rutinas;
    }

    public void AddRutina(DefaultTableModel rutina){

        runinas.add(rutina);

    }

    public ArrayList<DefaultTableModel> getRutinas() {
        return runinas;
    }
}
