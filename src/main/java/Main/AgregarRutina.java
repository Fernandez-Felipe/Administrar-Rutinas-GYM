package Main;

import Tools.SerializarRutina;
import Usuarios.RUTINAS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Main.InterfazRutinas.rutinas;

public class AgregarRutina extends JFrame {

    Connection Conn;
    JMenuBar MenuBar;
    JMenu Opciones, Dimenciones;
    JMenuItem AgregarFila,QuitarFila, GuardarRutina;
    int Columnas, Filas, ID;
    DefaultTableModel ModeloDeTabla;
    JTable Tabla;
    JScrollPane JSP;

    public AgregarRutina(int Columnas, int Filas, int ID, Connection Conn){

        this.Conn = Conn;
        this.ID = ID;
        this.Columnas = Columnas;
        this.Filas = Filas;

        setLayout(new BorderLayout());
        setSize(600,400);
        setLocationRelativeTo(null);

        ModeloDeTabla = new DefaultTableModel(Filas,Columnas);
        ModeloDeTabla.setRowCount(Filas);
        Tabla = new JTable(ModeloDeTabla);
        Tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        Tabla.setColumnSelectionAllowed(false);
        Tabla.getTableHeader().setReorderingAllowed(false);

        Tabla.setRowHeight(30);

        TamanioDeSeldas();

        JSP = new JScrollPane(Tabla);

        add(JSP,BorderLayout.CENTER);

        MenuBar = new JMenuBar();
        setJMenuBar(MenuBar);

        Dimenciones = new JMenu("Tamaño");
        MenuBar.add(Dimenciones);

        Opciones = new JMenu("Opciones");
        MenuBar.add(Opciones);

        GuardarRutina = new JMenuItem("Guardar Rutina");
        GuardarRutina.addActionListener(e -> {
            if(e.getSource() == GuardarRutina){
                try {
                    rutinas.AddRutina((DefaultTableModel) Tabla.getModel());
                    Tabla.getCellEditor().stopCellEditing();
                    InsertarRutinaNueva(rutinas);
                    dispose();
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        Opciones.add(GuardarRutina);

        AgregarFila = new JMenuItem("Agregar 1(Una) Fila");
        Dimenciones.add(AgregarFila);

        QuitarFila = new JMenuItem("Quitar 1(Una) Fila");
        Dimenciones.add(QuitarFila);

        JTableHeader JTH = Tabla.getTableHeader();
        JTH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = JTH.columnAtPoint(e.getPoint());
                String newName;
                if (col >= 0 && e.getClickCount() == 2) {
                    String Casilla = Tabla.getColumnName(col);
                    newName = JOptionPane.showInputDialog(
                            JTH,
                            "Editar encabezado de columna:",
                            Casilla
                    );

                    if(newName == null){
                        Tabla.getColumnModel().getColumn(col).setHeaderValue(" ");
                    }

                    Tabla.getColumnModel().getColumn(col).setHeaderValue(newName);
                    JTH.repaint();

                }
            }
        });

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void TamanioDeSeldas(){
        for(int i = 0; i < Columnas; i ++){

            if(i == 0){
                Tabla.getColumnModel().getColumn(i).setMinWidth(300);
            }

            Tabla.getColumnModel().getColumn(i).setMinWidth(150);

        }
    }

    private void InsertarRutinaNueva(RUTINAS ListaDeRutinas) throws SQLException, IOException {

        SerializarRutina SR = new SerializarRutina(ListaDeRutinas);

        PreparedStatement PSTM = Conn.prepareStatement("UPDATE usuarios SET rutina = ? WHERE id = ?");

        PSTM.setBytes(1, SR.RutinasEnBytes());
        PSTM.setInt(2,ID);

        PSTM.executeUpdate();

    }

    private void test(DefaultTableModel DTB){
        for (int i = 0; i < DTB.getRowCount(); i++) {
            for (int j = 0; j < DTB.getColumnCount(); j++) {
                Object value = DTB.getValueAt(i, j);
                if (value != null) {
                    System.out.println("Celda [" + i + "," + j + "] - Tipo: " + value.getClass().getName());
                }
            }
        }
    }

}
