package Usuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.ArrayList;

public class RUTINAS implements Serializable {

    private final ArrayList<DefaultTableModel> runinas;
    private final ArrayList<String> Titulos;

    public RUTINAS(ArrayList<DefaultTableModel> rutinas, ArrayList<String> Titulos){

        this.runinas = rutinas;
        this.Titulos = Titulos;

    }

    public void AddRutina(DefaultTableModel rutina){

        runinas.add(rutina);

    }

    public ArrayList<DefaultTableModel> getRutinas() {
        return runinas;
    }
    public ArrayList<String> getTitulos(){
        return Titulos;
    }
    public void addTitle(String title){
        Titulos.add(title);
    }
}
