package DataBase;

import Clases.Estudiante;

import java.io.*;

public class DataBase {

    public boolean guardarJugadores(Estudiante[] jugadores) {
        FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream("jugadores.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(jugadores);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }


        return false;
    }
}
