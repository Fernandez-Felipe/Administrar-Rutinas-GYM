package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ConfigTabla extends JFrame {

    JLabel Filas, Columnas;
    JTextField Num1, Num2;
    JButton Aceptar;
    Connection Conn;
    int N1, N2, ID;

    public ConfigTabla(Connection Conn, int ID){

        this.ID = ID;
        this.Conn = Conn;

        setLayout(null);
        setSize(270,180);
        setResizable(false);

        Init();

    }

    private void Init(){

        Filas = new JLabel("Nro de filas");
        Filas.setBounds(20,20,100,30);
        add(Filas);

        Num1 = new JTextField();
        Num1.setBounds(20,50,100,30);
        add(Num1);

        Columnas = new JLabel("Nro de Columnas");
        Columnas.setBounds(140,20,100,30);
        add(Columnas);

        Num2 = new JTextField();
        Num2.setBounds(140,50,100,30);
        add(Num2);

        Aceptar = new JButton("Aceptar");
        Aceptar.setBounds(70,90,120,30);
        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Aceptar){
                    N1 = Integer.parseInt(Num1.getText());
                    N2 = Integer.parseInt(Num2.getText());

                    AgregarRutina AR = new AgregarRutina(N2,N1,ID,Conn);
                    AR.setLocationRelativeTo(null);
                    AR.setVisible(true);

                    dispose();

                }
            }
        });
        add(Aceptar);

    }

}
