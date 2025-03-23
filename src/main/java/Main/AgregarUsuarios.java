package Main;



import Tools.GenRutinas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AgregarUsuarios extends JFrame {

    JLabel DNI, Nombre, Apellido;
    JTextField dni, nombre, apellido;
    JButton Aceptar;

    private final Connection Conn;

    public AgregarUsuarios(Connection Conn){

        this.Conn = Conn;

        setLayout(null);
        setSize(400,200);
        setLocationRelativeTo(null);
        setResizable(false);

        init();
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void init(){

        DNI = new JLabel("DNI");
        DNI.setBounds(20,20,100,30);
        add(DNI);

        dni = new JTextField();
        dni.setBounds(20,50,100,30);
        add(dni);

        Nombre = new JLabel("Nombre");
        Nombre.setBounds(140,20,100,30);
        add(Nombre);

        nombre = new JTextField();
        nombre.setBounds(140,50,100,30);
        add(nombre);

        Apellido = new JLabel("Apellido");
        Apellido.setBounds(260,20,100,30);
        add(Apellido);

        apellido = new JTextField();
        apellido.setBounds(260,50,100,30);
        add(apellido);

        Aceptar = new JButton("Agregar cliente");
        Aceptar.setBounds(120,100,140,30);
        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Aceptar){

                    try{

                        PreparedStatement pstm = Conn.prepareStatement("INSERT INTO usuarios (id,nombre,apellido,rutina)" +
                                                                           " VALUES (?,?,?,?)");

                        GenRutinas GR = new GenRutinas(Conn);

                        byte[] RutinasSerializadas = GR.GenerarRutina();

                        pstm.setInt(1,Integer.parseInt(dni.getText()));
                        pstm.setString(2,nombre.getText());
                        pstm.setString(3,apellido.getText());
                        pstm.setBytes(4,RutinasSerializadas);

                        pstm.executeUpdate();

                        dispose();

                    }catch (Exception ex){
                        System.out.println(ex);
                    }

                }
            }
        });
        add(Aceptar);
    }
}
