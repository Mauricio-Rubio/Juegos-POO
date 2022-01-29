import Sistema.Clases.Estudiante;
import Sistema.Interfaz;
import Sistema.Sistema;

public class Main {
    private static Estudiante[] students;
    private static Interfaz inter = new Interfaz();

    public static void main(String[] args) {
        //Vamos a establecer los casos prueba

        //Numero par de usuarios genericos (2)
        if(args[0].equals("a")){
            generar(2);
        }
        //Numero impar de usuario genericos (5)
        else if(args[0].equals("b")){
            generar(5);
        }
        // Multiples pares (10)
        else if(args[0].equals("c")){
            generar(10);
        }
        // Multiples impares (11)
        else if(args[0].equals("d")){
            generar(11);
        }

    }

    public static void generar(int x) {
        students = new Estudiante[x];
        String name = "Mauricio Rubio Haro", date = "29/08/2003", sex = "M", carrer = "Ciencias de la computacion";
        String[] dateArr = date.split("/");
        int TODAY = 2022;
        for (int i = 0; i < x; i++) {
            students[i] = new Estudiante(name, Integer.parseInt(dateArr[2]) - TODAY, sex, inter.generarID(name, dateArr[0], dateArr[2]) + String.valueOf(i), carrer);
        }
        new Sistema().iniciar(students);
    }
}
