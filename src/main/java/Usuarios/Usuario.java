package Usuarios;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private int Documento, ID;
    private String Nombre, Apellido;

    private ArrayList<Rutina> runinas = new ArrayList<>();

    public Usuario(int Documento, String Nombre, String Apellido){

        this.Documento = Documento;
        this.Nombre = Nombre;
        this.Apellido = Apellido;

    }

    public void AddRutina(Rutina rutina){

        runinas.add(rutina);

    }

    public int getDocumento() {
        return Documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public ArrayList<Rutina> getRuninas() {
        return runinas;
    }
}
