package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ConfigTabla extends JFrame {

    JLabel Filas, Columnas, Title;
    JTextField Num1, Num2;
    JButton Aceptar;
    JTextField Titulo;
    Connection Conn;
    int N1, N2, ID;

    public ConfigTabla(Connection Conn, int ID){

        this.ID = ID;
        this.Conn = Conn;

        setLayout(null);
        setSize(270,250);
        setResizable(false);

        Init();

    }

    private void Init(){

        Filas = new JLabel("Ejercicios");
        Filas.setBounds(20,20,100,30);
        add(Filas);

        Num1 = new JTextField();
        Num1.setBounds(20,50,100,30);
        add(Num1);

        Title = new JLabel("Titulo de la rutina");
        Title.setBounds(80,90,120,30);
        add(Title);

        Titulo = new JTextField();
        Titulo.setBounds(20,120,220,30);
        add(Titulo);

        Columnas = new JLabel("Semanas");
        Columnas.setBounds(140,20,100,30);
        add(Columnas);

        Num2 = new JTextField();
        Num2.setBounds(140,50,100,30);
        add(Num2);

        Aceptar = new JButton("Aceptar");
        Aceptar.setBounds(70,160,120,30);
        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Aceptar){
                    N1 = Integer.parseInt(Num1.getText());
                    N2 = Integer.parseInt(Num2.getText());

                    System.out.println(Titulo.getText());

                    AgregarRutina AR = new AgregarRutina(N2 + 1,N1,ID,Titulo.getText(),Conn);
                    AR.setLocationRelativeTo(null);
                    AR.setVisible(true);

                    dispose();

                }
            }
        });
        add(Aceptar);

    }

}
