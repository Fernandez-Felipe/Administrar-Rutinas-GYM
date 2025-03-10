package Usuarios;


import java.io.Serializable;

public class Ejercicio implements Serializable {

    private String Nombre;
    private int[][] Progrecion;

    public Ejercicio(String Nombre,int[][] Progrecion){

        this.Nombre = Nombre;
        this.Progrecion = Progrecion;

    }

    public String getNombre() {
        return Nombre;
    }

    public int[][] getProgrecion() {
        return Progrecion;
    }
}
