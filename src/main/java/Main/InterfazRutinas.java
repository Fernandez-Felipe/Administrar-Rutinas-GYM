package Main;

import Usuarios.RUTINAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterfazRutinas extends JFrame {

    JList<String> RutinasDeUsuario;
    JPanel  EjerciciosDeLaRutina;
    JLabel NombreDeUsuario;
    JButton BuscarUsuario, Agregar, Modificar, Quitar;
    DefaultListModel<String> ListaDeRutinas = new DefaultListModel<>();
    JMenuBar MenuBar;
    JMenu Options;
    JMenuItem AddUser, DeleteUser;

    static RUTINAS rutinas;

    public static int ID;

    public InterfazRutinas(){
        setLayout(null);
        setSize(new Dimension(751,520));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Init();

    }

    private void Init(){

        MenuBar = new JMenuBar();
        setJMenuBar(MenuBar);

        Options = new JMenu("Opciones");
        MenuBar.add(Options);

        AddUser = new JMenuItem("Agregar Usuario");
        AddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == AddUser){
                    AgregarUsuarios AU = new AgregarUsuarios();
                    AU.setLocationRelativeTo(null);
                    AU.setVisible(true);
                }
            }
        });
        Options.add(AddUser);

        DeleteUser = new JMenuItem("Elimianr Usuario");
        DeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == DeleteUser){
                    EliminarUsuario EU = new EliminarUsuario();
                    EU.setLocationRelativeTo(null);
                    EU.setVisible(true);
                }
            }
        });
        Options.add(DeleteUser);

        NombreDeUsuario = new JLabel("Rutinas de:");
        NombreDeUsuario.setBounds(25,60,230,30);
        add(NombreDeUsuario);


        //Botonos
        BuscarUsuario = new JButton("Buscar");
        BuscarUsuario.setBounds(240,60,100,30);
        BuscarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == BuscarUsuario){

                        BuscarUsuario B = new BuscarUsuario();
                        B.setLocationRelativeTo(null);
                        B.setVisible(true);

                }
            }
        });
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
        EjerciciosDeLaRutina = new JPanel();

        JScrollPane scrollPaneRutinas = new JScrollPane(RutinasDeUsuario);
        scrollPaneRutinas.setBounds(25,100,316,350);
        add(scrollPaneRutinas);

        EjerciciosDeLaRutina.setBounds(350,100,376,250);
        EjerciciosDeLaRutina.setBackground(Color.white);
        add(EjerciciosDeLaRutina);

    }

    public void CargarRutinas(Connection Conn) throws SQLException, IOException, ClassNotFoundException {

        PreparedStatement pstm = Conn.prepareStatement("SELECT rutina FROM usuarios WHERE id = ?");

        pstm.setInt(1,ID);

        ResultSet rs = pstm.executeQuery();

        if(rs.next()){
            byte[] Rutinas = rs.getBytes("rutina");
            ByteArrayInputStream BAIS = new ByteArrayInputStream(Rutinas);
            ObjectInputStream OIS = new ObjectInputStream(BAIS);

            rutinas = (RUTINAS) OIS.readObject();

        }

        if(rutinas.getRuninas().isEmpty()){
            ListaDeRutinas.removeAllElements();
            ListaDeRutinas.addElement("No hay rutinas registradas");
        }

    }

}
