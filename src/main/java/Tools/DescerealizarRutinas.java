package Tools;

import Usuarios.RUTINAS;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DescerealizarRutinas {

    public RUTINAS LeerBytesDeRutinas(byte[] Rutina) throws IOException, ClassNotFoundException {

        ByteArrayInputStream BAIS = new ByteArrayInputStream(Rutina);
        ObjectInputStream OIS = new ObjectInputStream(BAIS);

        return (RUTINAS) OIS.readObject();

    }

}
