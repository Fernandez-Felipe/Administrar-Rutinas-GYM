package Usuarios;

import java.io.Serializable;
import java.util.ArrayList;

public class Rutina implements Serializable {

    private ArrayList<Ejercicio> rutina = new ArrayList<>();

    private final int Dias, EjerciciosPorDia;

    public Rutina(int Dias, int EjerciciosPorDia){
        this.Dias = Dias;
        this.EjerciciosPorDia = EjerciciosPorDia;
    }

    public ArrayList<Ejercicio> getRutina() {
        return rutina;
    }

    public int getDias() {
        return Dias;
    }

    public int getEjerciciosPorDia() {
        return EjerciciosPorDia;
    }

    public void AgregarEjercicio(Ejercicio ejercicio){

        rutina.add(ejercicio);

    }

}
