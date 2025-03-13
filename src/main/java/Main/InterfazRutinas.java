package Main;

import Tools.ConnectionDB;
import Tools.DescerealizarRutinas;
import Tools.GetData;
import Usuarios.Ejercicio;
import Usuarios.RUTINAS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class InterfazRutinas extends ConnectionDB {


    JFrame InterfazPrincipal;
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

        InterfazPrincipal = new JFrame();

        InterfazPrincipal.setLayout(null);
        InterfazPrincipal.setSize(new Dimension(751,520));
        InterfazPrincipal.setLocationRelativeTo(null);
        InterfazPrincipal.setResizable(false);
        InterfazPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Init();

    }

    private void Init(){

        MenuBar = new JMenuBar();
        InterfazPrincipal.setJMenuBar(MenuBar);

        Options = new JMenu("Opciones");
        MenuBar.add(Options);

        AddUser = new JMenuItem("Agregar Usuario");
        AddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == AddUser){
                    AgregarUsuarios AU = new AgregarUsuarios(getConn());
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
                    EliminarUsuario EU = new EliminarUsuario(getConn());
                    EU.setLocationRelativeTo(null);
                    EU.setVisible(true);
                }
            }
        });
        Options.add(DeleteUser);

        NombreDeUsuario = new JLabel("Rutinas de:");
        NombreDeUsuario.setBounds(25,60,230,30);
        InterfazPrincipal.add(NombreDeUsuario);


        //Botonos
        BuscarUsuario = new JButton("Buscar");
        BuscarUsuario.setBounds(240,60,100,30);
        BuscarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == BuscarUsuario){

                        BuscarUsuario B = new BuscarUsuario(getConn());
                        B.setLocationRelativeTo(null);
                        B.setVisible(true);

                }
            }
        });
        InterfazPrincipal.add(BuscarUsuario);

        Agregar = new JButton("Agregar Rutina");
        Agregar.setBounds(350,390,120,30);
        Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Agregar){
                    ConfigTabla CT = new ConfigTabla(getConn(),ID);
                    CT.setLocationRelativeTo(null);
                    CT.setVisible(true);

                    System.out.println(rutinas.getRutinas().size());

                }
            }
        });
        InterfazPrincipal.add(Agregar);

        Modificar = new JButton("Modificar Rutina");
        Modificar.setBounds(473,390,130,30);
        InterfazPrincipal.add(Modificar);

        Quitar = new JButton("Eliminar Rutina");
        Quitar.setBounds(606,390,120,30);
        InterfazPrincipal.add(Quitar);

        RutinasDeUsuario = new JList<>(ListaDeRutinas);
        EjerciciosDeLaRutina = new JPanel();
        EjerciciosDeLaRutina.setLayout(new BorderLayout());

        Exel esel = new Exel();

        JScrollPane scrollPaneRutinas = new JScrollPane(RutinasDeUsuario);
        scrollPaneRutinas.setBounds(25,100,316,350);
        InterfazPrincipal.add(scrollPaneRutinas);

        EjerciciosDeLaRutina.setBounds(350,100,376,250);
        EjerciciosDeLaRutina.setBackground(Color.white);

        JScrollPane JSPE = new JScrollPane(esel);


        EjerciciosDeLaRutina.add(JSPE,BorderLayout.CENTER);
        EjerciciosDeLaRutina.setVisible(true);


        InterfazPrincipal.add(EjerciciosDeLaRutina);

    }

    public void CargarRutinas(Connection Conn) throws SQLException, IOException, ClassNotFoundException {

        GetData GD = new GetData();

        ResultSet rs = GD.ObtenerDatos(ID,getConn());
        DescerealizarRutinas DR = new DescerealizarRutinas();

        if(rs.next()){
            byte[] Rutinas = rs.getBytes("rutina");
            rutinas = DR.LeerBytesDeRutinas(Rutinas);
        }

        if(rutinas.getRutinas().isEmpty()){
            ListaDeRutinas.removeAllElements();
            ListaDeRutinas.addElement("No hay rutinas registradas");
        }

    }

    static class Exel extends JTable{

        public Exel() {
            // Definir los nombres de las columnas
            String[] columnas = {"ID", "Nombre", "Edad","Aca va a ir un texto largo"};

            // Definir los datos con una sola fila
            Object[][] datos = {
                    {1, "Juan Carlos Ramirez de Nuestro Señor Jesucristo el salvador del mundo", 25}
            };

            // Establecer el modelo de la tabla
            DefaultTableModel modelo = new DefaultTableModel(5, 6);
            this.setModel(modelo);

            this.getColumnModel().getColumn(1).setMinWidth(200);
            this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        }

    }

}
