package Sistema;

import Sistema.Clases.Estudiante;
import Sistema.IA.IA;
import Sistema.Juegos.BlackJack.Carta;

public class Interfaz {
    /**
     * Generar ID
     * 
     * @param nombre
     * @param dia
     * @param year
     * @return String
     */
    public String generarID(String nombre, String dia, String year) {
        int numero = (int) (Math.random() * 1000 + 1);
        return String.valueOf(numero) + nombre.charAt(0) + nombre.charAt(2) + year.charAt(2) + year.charAt(3);
    }

    /**
     * Generar ID
     * para IA
     * 
     * @param nombre
     * @return String
     */
    public String generarID(String nombre) {
        int numero = (int) (Math.random() * 1000 + 1);
        return String.valueOf(numero) + nombre.charAt(0) + nombre.charAt(1);
    }

    /**
     * distribuir jugadores
     * asignar quien jugara contra quien
     * visto de forma matricial
     * 
     * @param students
     * @return Estudiante [][]
     */
    public Estudiante[][] distribuirJugadores(Estudiante[] students) {
        Estudiante[][] studentsRepartition;
        int modulo = students.length % 2;
        if (modulo == 0) {
            // System.out.println("Es par");
            studentsRepartition = new Estudiante[2][students.length / 2];
            for (int i = 0; i < studentsRepartition[0].length; i++) {
                studentsRepartition[0][i] = students[2 * i];
                studentsRepartition[1][i] = students[(2 * (i + 1)) - 1];
            }
        } else {
            // System.out.println("Es impar");
            studentsRepartition = new Estudiante[2][(students.length + 1) / 2];
            for (int i = 0; i < studentsRepartition[0].length; i++) {
                studentsRepartition[0][i] = students[2 * i];
            }
            for (int i = 0; i < studentsRepartition[0].length - 1; i++) {
                studentsRepartition[1][i] = students[(2 * (i + 1)) - 1];
            }
            // studentsRepartition[1][(students.length - 1) / 2] = new
            // Estudiante("Sistema.IA", generarID("Sistema.IA"));
            studentsRepartition[1][(students.length - 1) / 2] = new IA("IA", generarID("IA"));
        }
        return studentsRepartition;
    }

    /**
     * Desordenar Arreglo
     * 
     * @param students
     * @return Estudiante []
     */
    public Estudiante[] desordenarArreglo(Estudiante[] students) {
        Estudiante aux;
        int aleatorio;
        for (int i = 0; i < students.length; i++) {
            aleatorio = random(students.length) - 1;
            aux = students[aleatorio];
            students[aleatorio] = students[i];
            students[i] = aux;
        }
        return students;
    }

    /**
     * Random
     * generar random
     * 
     * @param max
     * @return int
     */
    private int random(int max) {
        return (int) Math.round(Math.random() * max + 0.5);
    }
    /**
     * Mostar Matriz
     * @param students
     */
    public void mostrarMatriz(Estudiante[][] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].length; j++) {
                System.out.println(students[i][j]);
            }
        }
    }

    /**
     * Mostrar Arreglo
     * @param students
     */
    public void mostrarArreglo(Estudiante[] students) {
        for (Estudiante es : students) {
            System.out.println(es);
        }
    }
}
