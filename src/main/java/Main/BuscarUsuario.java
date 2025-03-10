package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarUsuario extends JFrame {

    JLabel label;
    JTextField JTF;
    JButton Search;
    Connection Conn;
    PreparedStatement pstm;
    String SQL = "SELECT * FROM usuarios WHERE id = ?";
    int id;

    public BuscarUsuario(){
        setLayout(new BorderLayout());
        setSize(300, 180);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Init();

    }

    public void Init() {
        label = new JLabel("Nro de documento", SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(15, 0, 15, 0));
        add(label, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JTF = new JTextField();
        JTF.setPreferredSize(new Dimension(120, 30)); // Define el tamaño sin setBounds()

        panelCentro.add(JTF);
        add(panelCentro, BorderLayout.CENTER);

        JPanel PanelDeAbjao = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Search = new JButton("Buscar");
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Search ){
                    id = Integer.parseInt(JTF.getText());

                    try {
                        Conn = main.Conectar.getConn();
                        pstm = Conn.prepareStatement(SQL);

                        pstm.setInt(1, id);
                        ResultSet rs = pstm.executeQuery();

                        if (rs.next()) {

                            String nombre = rs.getString(2);
                            String apellido = rs.getString(3);

                            main.Window.NombreDeUsuario.setText("");
                            main.Window.NombreDeUsuario.setText("Rutina de: "+nombre+" "+apellido);

                            System.out.println("Nombre: " + nombre);
                            System.out.println("Edad: " + apellido);

                            InterfazRutinas.ID = rs.getInt(1);

                            main.Window.CargarRutinas(Conn);

                            dispose();

                        } else {
                            System.out.println("No se encontró el registro con el ID especificado.");
                        }
                    }catch (Exception ex){
                        System.out.println(ex);
                    }

                }
            }
        });
        Search.setPreferredSize(new Dimension(140, 30));
        PanelDeAbjao.add(Search);
        PanelDeAbjao.setBorder(new EmptyBorder(0, 0, 20, 0));
        add(PanelDeAbjao, BorderLayout.SOUTH);


        add(panelCentro, BorderLayout.CENTER);

    }
}