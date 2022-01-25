package Sistema;

import Clases.*;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Sistema {
    int[] dias = {1, 2, 3};
    private Estudiante[] students;
    Scanner sc = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);

    public void iniciar() {
        System.out.println("Bienvenido al torneo");
        menu();
    }

    public void menu() {
        //Aqui debemos preguntar si ya existe un juego en memoria
        System.out.println("Ya existe (S/N)");
        String elec = sc.nextLine();
        if (elec.equals("s") || elec.equals("S")) {
            //iniciar juego precargado
        } else {
            registrar();
        }
    }

    public void registrar() {
        sc = new Scanner(System.in);
        scInt = new Scanner(System.in);
        System.out.println("Ingresa el numero de estudiantes");
        students = new Estudiante[scInt.nextInt()];
        for (Estudiante est: students) {
            System.out.println("Estudiantes --->"+est);
        }
        try {
            llenarRegistro();
            for (Estudiante est: students) {
                System.out.println(est);
            }
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    public void llenarRegistro() throws Exception {
        try {
            sc = new Scanner(System.in);
            scInt = new Scanner(System.in);
            String name, date, sex, carrer;
            System.out.println("Es null --->"+students);
            System.out.println("student 0 --->"+students[0]);
            if (students[0] == null) {
                System.out.println("student 0 --->"+students[0]);
                for (int i = 0; i < students.length; i++) {
                    //students[i] = new Estudiante();
                    System.out.println("Ingresa el nombre completo del estudiante " + i);
                    name = sc.nextLine();
                    //System.out.println(name);
                    System.out.println("Fecha de nacimiento (dd/mm/aaaa) " + i);
                    date = sc.nextLine();
                    System.out.println("Sexo (Masculino: M, Femenino F, Otro X) " + i);
                    sex = sc.nextLine();
                    System.out.println("Carrera " + i);
                    carrer = sc.nextLine();
                    if (validarDataRegistro(name, date, sex, carrer)) {
                        students[i] = new Estudiante(name, 0, sex, "123", carrer);
                    } else {
                        System.out.println("Debes ingresar los datos correctamente");
                        String eleecion;
                        do {
                            System.out.println("Deseas continuar (S/N) 1");
                            eleecion = sc.nextLine();
                            if (eleecion.equals("S") || eleecion.equals("s")) {
                                llenarRegistro();
                            } else if (eleecion.equals("N") || eleecion.equals("n")) {
                                break;
                            }
                        } while (!eleecion.equals("S") || !eleecion.equals("s") || !eleecion.equals("n") || !eleecion.equals("N"));
                    }
                }
            } else {
                int posLlenas = 1;
                for (int x = 0; x < students.length; x++) {
                    if (students[x] != null) {
                        posLlenas++;
                    }
                }
                llenarRegistroExistente(posLlenas - 1);
            }

        } catch (Exception e) {
            throw new Exception();
        }
    }

    public void llenarRegistroExistente(int i) {
        sc = new Scanner(System.in);
        scInt = new Scanner(System.in);
        String name, date, sex, carrer;
        for (i = i; i < students.length; i++) {
            //students[i] = new Estudiante();
            System.out.println("Ingresa el nombre completo del estudiante " + (i+1));
            name = sc.nextLine();
            System.out.println("Fecha de nacimiento (dd/mm/aaaa) " + (i+1));
            date = sc.nextLine();
            System.out.println("Sexo (Masculino: M, Femenino F, Otro X) " + (i+1));
            sex = sc.nextLine();
            System.out.println("Carrera " + (i+1));
            carrer = sc.nextLine();
            if (validarDataRegistro(name, date, sex, carrer)) {
                students[i] = new Estudiante(name, 0, sex, "123", carrer);
            } else {
                System.out.println("Debes ingresar los datos correctamente");
                String eleecion;
                do {
                    System.out.println("Deseas continuar (S/N) 2");
                    eleecion = sc.nextLine();
                    if (eleecion.equals("S") || eleecion.equals("s")) {
                        try {
                            llenarRegistro();
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    } else if (eleecion.equals("N") || eleecion.equals("n")) {
                        break;
                    }
                } while (!eleecion.equals("S") || !eleecion.equals("s") || !eleecion.equals("n") || !eleecion.equals("N"));
            }
        }
    }

    public boolean validarDataRegistro(String name, String date, String sex, String carrer) {
        if (name.length() > 2) {
            String[] dateArr = date.split("/");
            try {
                int ed1 = Integer.parseInt(dateArr[0]), ed2 = Integer.parseInt(dateArr[1]), ed3 = Integer.parseInt(dateArr[2]);
                if (ed1 >= 1 && ed1 <= 31 && ed2 >= 1 && ed2 <= 12 && ed3 >= 1930 && ed3 <= 2010) {
                    if (sex.equals("M") || sex.equals("m") || sex.equals("f") || sex.equals("F") || sex.equals("x") || sex.equals("X")) {
                        if (carrer.length() >= 5) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                return false;
            }
            //return true;
        }
        return false;
    }

    public void concursantes() {

    }

    public void partidas() {

    }

    public void listaTorneo() {

    }

    ;
}
