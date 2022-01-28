package DataBase;

import Clases.Estudiante;

import java.io.*;

public class DataBase {

    public boolean guardarJugadores(Estudiante[] students) {
        FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream("students.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                fichero.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    public Estudiante [] leerEstudiantes(){
        FileInputStream ficheroEntrada = null;
        Estudiante [] students=null;
        try {
            ficheroEntrada = new FileInputStream("students.txt");
            ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
            students = (Estudiante[]) tuberiaEntrada.readObject();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e1){
            e1.printStackTrace();
        }catch (ClassNotFoundException e2){
            e2.printStackTrace();
        }catch (Exception e4){
            System.out.println("Error en la matriz");
            e4.printStackTrace();
        }
        finally{
            try {
                ficheroEntrada.close();
                return students;
            }catch (IOException e3){
                e3.printStackTrace();
            }
        }

        return students;
    }
}
