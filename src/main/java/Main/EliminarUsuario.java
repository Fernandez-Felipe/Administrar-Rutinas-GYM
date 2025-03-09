package Main;

import javax.swing.*;
import java.awt.*;

public class EliminarUsuario extends JFrame {

    JTextField DNI;
    JLabel NroDNI, nombre, apellido;

    JButton Buscar, Eliminar;

    public EliminarUsuario(){
        setLayout(null);
        setSize(525,220);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().setBackground(Color.lightGray);

        Init();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void Init(){

        DNI = new JTextField();
        DNI.setBounds(15,15,150,30);
        DNI.setBorder(null);
        add(DNI);

        Buscar = new JButton("Buscar Cliente");
        Buscar.setBounds(180,15,150,30);
        add(Buscar);

        NroDNI = new JLabel();
        NroDNI.setBackground(Color.WHITE);
        NroDNI.setBounds(15,70,150,30);
        NroDNI.setOpaque(true);
        add(NroDNI);

        nombre = new JLabel();
        nombre.setBackground(Color.WHITE);
        nombre.setBounds(180,70,150,30);
        nombre.setOpaque(true);
        add(nombre);

        apellido = new JLabel();
        apellido.setBackground(Color.WHITE);
        apellido.setBounds(343,70,150,30);
        apellido.setOpaque(true);
        add(apellido);

        Eliminar = new JButton("Eliminar cliente");
        Eliminar.setBounds(180,120,150,30);
        add(Eliminar);

    }

}
