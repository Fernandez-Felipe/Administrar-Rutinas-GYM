package Usuarios;

import java.io.Serializable;
import java.util.ArrayList;

public class RUTINAS implements Serializable {

    private ArrayList<Rutina> runinas;

    public RUTINAS(ArrayList<Rutina> rutinas){
        this.runinas = rutinas;
    }

    public void AddRutina(Rutina rutina){

        runinas.add(rutina);

    }

    public ArrayList<Rutina> getRuninas() {
        return runinas;
    }
}
