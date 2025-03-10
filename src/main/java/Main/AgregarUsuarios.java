package Main;



import Usuarios.Ejercicio;
import Usuarios.RUTINAS;
import Usuarios.Rutina;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class AgregarUsuarios extends JFrame {

    JLabel DNI, Nombre, Apellido;
    JTextField dni, nombre, apellido;
    JButton Aceptar;

    Connection Conn;

    public AgregarUsuarios(){
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

                        Conn = main.Conectar.getConn();
                        PreparedStatement pstm = Conn.prepareStatement("INSERT INTO usuarios (id,nombre,apellido,rutina)" +
                                                                           " VALUES (?,?,?,?)");

                        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
                        ObjectOutputStream OOS = new ObjectOutputStream(BAOS);
                        OOS.writeObject(new RUTINAS(new ArrayList<Rutina>()));
                        OOS.close();

                        byte[] RutinasSerializadas = BAOS.toByteArray();

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
