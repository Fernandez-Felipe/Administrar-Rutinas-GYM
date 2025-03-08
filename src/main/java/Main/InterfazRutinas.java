package Main;

import javax.swing.*;
import java.awt.*;

public class InterfazRutinas extends JFrame {

    JList<String> RutinasDeUsuario, EjerciciosDeLaRutina;
    JLabel NombreDeUsuario;
    JButton BuscarUsuario, Agregar, Modificar, Quitar;
    DefaultListModel<String> ListaDeRutinas = new DefaultListModel<>();

    public InterfazRutinas(){
        setLayout(null);
        setSize(new Dimension(751,500));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Init();

        setVisible(true);
    }

    private void Init(){
        ListaDeRutinas.addElement("Funciona");

        NombreDeUsuario = new JLabel("Rutinas de: Fernandez Felipe Ruben");
        NombreDeUsuario.setBounds(25,60,230,30);
        add(NombreDeUsuario);


        //Botonos
        BuscarUsuario = new JButton("Buscar");
        BuscarUsuario.setBounds(240,60,100,30);
        add(BuscarUsuario);

        Agregar = new JButton("Agregar Rutina");
        Agregar.setBounds(350,390,120,30);
        add(Agregar);

        Modificar = new JButton("Modificar Rutina");
        Modificar.setBounds(473,390,130,30);
        add(Modificar);

        Quitar = new JButton("Eliminar Rutina");
        Quitar.setBounds(606,390,120,30);
        add(Quitar);

        RutinasDeUsuario = new JList<>(ListaDeRutinas);
        EjerciciosDeLaRutina = new JList<>();

        JScrollPane scrollPaneRutinas = new JScrollPane(RutinasDeUsuario);
        scrollPaneRutinas.setBounds(25,100,316,350);
        add(scrollPaneRutinas);

        JScrollPane scrollPaneEjercicion = new JScrollPane(EjerciciosDeLaRutina);
        scrollPaneEjercicion.setBounds(350,100,376,250);
        add(scrollPaneEjercicion);

    }
}
