package Sistema.DataBase;

import Sistema.Clases.Estudiante;

import java.io.*;

public class DataBase {
    int contador1=0,contador2=0,contador3=0,contador4=0;
    public boolean guardarJugadores(Estudiante[] students) {
        FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream("Sistema/DataBase/students.txt");
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

    public boolean guardarGanadores(Estudiante[] students) {
        System.out.println("Esto vale contador-->"+contador1);
        FileOutputStream fichero = null;
        try {
            if (contador1 == 0) {
                fichero = new FileOutputStream("Sistema/DataBase/dia1.txt");
            }
            if (contador1 == 1) {
                fichero = new FileOutputStream("Sistema/DataBase/dia2.txt");
            }
            if (contador1 == 2) {
                fichero = new FileOutputStream("Sistema/DataBase/dia3.txt");
            }
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                fichero.close();
                contador1++;
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }
    public boolean guardarPartidas(Estudiante[][] students) {
        FileOutputStream fichero = null;
        try {
            if (contador2 == 0) {
                fichero = new FileOutputStream("Sistema/DataBase/JugadoresDia1.txt");
            }
            if (contador2 == 1) {
                fichero = new FileOutputStream("Sistema/DataBase/JugadoresDia2.txt");
            }
            if (contador2 == 2) {
                fichero = new FileOutputStream("Sistema/DataBase/JugadoresDia3.txt");
            }
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                fichero.close();
                contador2++;
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    public Estudiante[] leerPartidas() {
        FileInputStream ficheroEntrada = null;
        Estudiante[] students = null;
        File f1 = null;
        try {
            if (contador3 == 0){
            f1= new File("Sistema/DataBase/dia1.txt");
            }else if(contador3 == 1){
                f1= new File("Sistema/DataBase/dia2.txt");
            }else if(contador3 == 3){
                f1= new File("Sistema/DataBase/dia3.txt");
            }

            if (f1.exists() && !f1.isDirectory()) {
                ficheroEntrada = new FileInputStream(f1);
                ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
                students = (Estudiante[]) tuberiaEntrada.readObject();
            }else{
                return null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e4) {
            System.out.println("Error en la matriz");
            e4.printStackTrace();
        } finally {
            try {
                ficheroEntrada.close();
                return students;
            } catch (IOException e3) {
                e3.printStackTrace();
            }catch (Exception e4){
                return null;
            }
        }

        return students;
    }
    public Estudiante[][] leerPartidasJugadores() {
        FileInputStream ficheroEntrada = null;
        Estudiante[][] students = null;
        File f1 = null;
        try {
            if (contador4 == 0){
                f1= new File("Sistema/DataBase/JugadoresDia1.txt");
            }else if(contador4 == 1){
                f1= new File("Sistema/DataBase/JugadoresDia2.txt");
            }else if(contador4 == 3){
                f1= new File("Sistema/DataBase/JugadoresDia3.txt");
            }

            if (f1.exists() && !f1.isDirectory()) {
                ficheroEntrada = new FileInputStream(f1);
                ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
                students = (Estudiante[][]) tuberiaEntrada.readObject();
            }else{
                return null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e4) {
            System.out.println("Error en la matriz");
            e4.printStackTrace();
        } finally {
            try {
                ficheroEntrada.close();
                return students;
            } catch (IOException e3) {
                e3.printStackTrace();
            }catch (Exception e4){
                return null;
            }
        }

        return students;
    }

    public Estudiante[] leerEstudiantes() {
        FileInputStream ficheroEntrada = null;
        Estudiante[] students = null;
        try {
            File f1 = new File("Sistema/DataBase/students.txt");
            if (f1.exists() && !f1.isDirectory()) {
                ficheroEntrada = new FileInputStream("Sistema/DataBase/students.txt");
                ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
                students = (Estudiante[]) tuberiaEntrada.readObject();
            }else{
                return null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e4) {
            System.out.println("Error en la matriz");
            e4.printStackTrace();
        } finally {
            try {
                ficheroEntrada.close();
                return students;
            } catch (IOException e3) {
                e3.printStackTrace();
            }catch (Exception e4){
                return null;
            }
        }

        return students;
    }
}
