package Main;

import Tools.ConnectionDB;
import DataBase.Statements;
import Tools.DescerealizarRutinas;
import Tools.GetData;
import Usuarios.RUTINAS;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class EliminarUsuario extends JFrame {

    Connection Conn;
    Statements Stm;
    private ResultSet RS;
    JTextField DNI;
    JLabel NroDR, nombre, apellido;

    JButton Buscar, Eliminar;

    public EliminarUsuario(Connection Conn){

        this.Conn = Conn;

        setLayout(null);
        setSize(525,220);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().setBackground(Color.lightGray);

        Stm = new Statements();

        Init();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void Init(){

        DNI = new JTextField();
        DNI.setBounds(15,15,150,30);
        DNI.setBorder(new LineBorder(Color.BLACK));
        add(DNI);

        Buscar = new JButton("Buscar Cliente");
        Buscar.setBounds(180,15,150,30);
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Buscar){
                    try {

                        GetData GT = new GetData();

                        RS = GT.ObtenerDatos(Integer.parseInt(DNI.getText()),Conn);
                        DescerealizarRutinas DR = new DescerealizarRutinas();
                        if(RS.next()){



                            nombre.setText(RS.getString("nombre"));
                            apellido.setText(RS.getString("apellido"));

                            byte[] RutinasEnBytes = RS.getBytes("rutina");

                            RUTINAS RutinasDelUsuario = DR.LeerBytesDeRutinas(RutinasEnBytes);

                            NroDR.setText(String.valueOf(RutinasDelUsuario.getRutinas().size()));

                        }

                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }
        });
        add(Buscar);

        NroDR = new JLabel();
        NroDR.setBackground(Color.WHITE);
        NroDR.setBounds(343,70,150,30);
        NroDR.setBorder(new LineBorder(Color.BLACK));
        NroDR.setOpaque(true);
        add(NroDR);

        nombre = new JLabel();
        nombre.setBackground(Color.WHITE);
        nombre.setBounds(15,70,150,30);
        nombre.setBorder(new LineBorder(Color.BLACK));
        nombre.setOpaque(true);
        add(nombre);

        apellido = new JLabel();
        apellido.setBackground(Color.WHITE);
        apellido.setBounds(180,70,150,30);
        apellido.setOpaque(true);
        apellido.setBorder(new LineBorder(Color.BLACK));
        add(apellido);

        Eliminar = new JButton("Eliminar cliente");
        Eliminar.setBounds(180,120,150,30);
        add(Eliminar);

    }

}
