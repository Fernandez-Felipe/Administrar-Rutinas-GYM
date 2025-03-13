package Tools;

import Usuarios.RUTINAS;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.util.ArrayList;

public class GenRutinas {

    Connection Conn;

    byte[] RutinasSerializadas;

    public GenRutinas(Connection Conn){

        this.Conn = Conn;

    }

    public byte[] GenerarRutina(){

        RUTINAS RutinasNuevas = new RUTINAS(new ArrayList<>());

        try{

           ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
           ObjectOutputStream OUS = new ObjectOutputStream(BAOS);

           OUS.writeObject(RutinasNuevas);

           RutinasSerializadas = BAOS.toByteArray();


        }catch (Exception ex){
            System.out.println(ex);
        }

        return  RutinasSerializadas;

    }

}
