package Sistema;

import Clases.Estudiante;

public class Main {
    public static void main(String[] args) {
        Interfaz inter = new Interfaz();
        Estudiante [] students = new Estudiante[2];
        String name = "Mauricio Rubio Haro", date = "29/08/2003", sex ="M", carrer = "Ciencias de la computacion";
        String[] dateArr = date.split("/");
        int TODAY = 2022;
        for(int i = 0; i<2;i++) {
            students[i] = new Estudiante(name, Integer.parseInt(dateArr[2]) - TODAY, sex, inter.generarID(name, dateArr[0], dateArr[2])+String.valueOf(i), carrer);
        }new Sistema().iniciar(students);
    }
}
