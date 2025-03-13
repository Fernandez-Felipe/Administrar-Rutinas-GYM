package Tools;

import Usuarios.RUTINAS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;

public class SerializarRutina {
    RUTINAS rutinas;

    public SerializarRutina(RUTINAS rutinas){
        this.rutinas = rutinas;
    }

    public byte[] RutinasEnBytes() throws IOException {

        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
        ObjectOutputStream OOS = new ObjectOutputStream(BAOS);

        OOS.writeObject(rutinas);

        return BAOS.toByteArray();

    }

}
