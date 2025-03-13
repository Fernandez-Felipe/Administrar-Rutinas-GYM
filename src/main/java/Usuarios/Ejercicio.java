package Usuarios;


import javax.swing.table.DefaultTableModel;
import java.io.Serializable;

public class Ejercicio implements Serializable {

    private String Nombre;
    private double[] Progrecion;

    public Ejercicio(String Nombre,double[] Progrecion){

        this.Nombre = Nombre;
        this.Progrecion = Progrecion;

    }

    public String getNombre() {
        return Nombre;
    }

    public double[] getProgrecion() {
        return Progrecion;
    }

}
