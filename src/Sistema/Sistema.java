package Sistema;

import Clases.*;
import Juegos.BlackJack.miniBlackJack;
import Juegos.Conecta4.JugarConecta;
import Juegos.Jugar;

import java.util.*;

public class Sistema {
    int[] dias = {1, 2, 3};
    private Estudiante[] students;
    private Jugar[] juegos = new Jugar[3];
    Interfaz inter = new Interfaz();
    Scanner sc = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);

    public void iniciar(Estudiante [] arr) {
        System.out.println("Bienvenido al torneo");
        students = arr;
        menu();
    }

    public void menu() {
        //Aqui debemos preguntar si ya existe un juego en memoria
        System.out.println("Ya existe (S/N)");
        String elec = sc.nextLine();
        if (elec.equals("s") || elec.equals("S")) {
            //iniciar juego precargado
        } else {
            if((elec.equals("n") || elec.equals("N")) && registrar()){
                System.out.println("Registro exitoso");
                comenzarJuego();
            }else{
                menu();
            }
        }
    }

    public boolean registrar() {
        sc = new Scanner(System.in);
        scInt = new Scanner(System.in);
       // System.out.println("Ingresa el numero de estudiantes (minimo 2)");
       // String x = scInt.nextLine();
        int nStunden = students.length;
        /*for(int i = 0; i<students.length;i++){
            System.out.println(students[i]);
        }*/
        //System.out.println("Esto vale stundets--->"+nStunden);
        try {
         //   nStunden = Integer.parseInt(x);
            if (nStunden >= 1) {
                //students = new Estudiante[nStunden];
                try {
                    //llenarRegistro();
                    //for (Estudiante est : students) {
                      //  System.out.println(est);
                    //}
                   // for (int z = 0; z<students.length; z++){
                     //   System.out.println(students[z]);
                    //}
                    if(students != null){
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println("Error inesperado");
                }
            } else {
                System.out.println("Debes ingresar un numero valido");
                String eleecion;
                do {
                    System.out.println("Deseas continuar (S/N) 1");
                    eleecion = sc.nextLine();
                    if (eleecion.equals("S") || eleecion.equals("s")) {
                        registrar();
                    } else if (eleecion.equals("N") || eleecion.equals("n")) {
                        break;
                    }
                } while (!eleecion.equals("S") || !eleecion.equals("s") || !eleecion.equals("n") || !eleecion.equals("N"));
            }
        } catch (Exception e) {
            System.out.println("Debes ingresar un numero valido");
            String eleecion;
            do {
                System.out.println("Deseas continuar (S/N)");
                eleecion = sc.nextLine();
                if (eleecion.equals("S") || eleecion.equals("s")) {
                    registrar();
                } else if (eleecion.equals("N") || eleecion.equals("n")) {
                    break;
                }
            } while (!eleecion.equals("S") || !eleecion.equals("s") || !eleecion.equals("n") || !eleecion.equals("N"));

        }
        return false;
    }

    public void llenarRegistro() throws Exception {
        try {
            sc = new Scanner(System.in);
            scInt = new Scanner(System.in);
            String name, date, sex, carrer;
            //System.out.println("Es null --->"+students);
            if (students[0] == null) {
                for (int i = 0; i < students.length; i++) {
                    //students[i] = new Estudiante();
                    System.out.println("Ingresa el nombre completo del estudiante " + (i + 1));
                    name = sc.nextLine();
                    //System.out.println(name);
                    System.out.println("Fecha de nacimiento (dd/mm/aaaa) ");
                    date = sc.nextLine();
                    System.out.println("Sexo (Masculino: M, Femenino F, Otro X) ");
                    sex = sc.nextLine();
                    System.out.println("Carrera " + (i + 1));
                    carrer = sc.nextLine();
                    if (validarDataRegistro(name, date, sex, carrer)) {
                        String[] dateArr = date.split("/");
                        int TODAY = 2022;
                        students[i] = new Estudiante(name, Integer.parseInt(dateArr[2]) - TODAY, sex, inter.generarID(name, dateArr[0], dateArr[2]), carrer);
                    } else {
                        System.out.println("Debes ingresar los datos correctamente");
                        String eleecion;
                        do {
                            System.out.println("Deseas continuar (S/N) 1");
                            eleecion = sc.nextLine();
                            if (eleecion.equals("S") || eleecion.equals("s")) {
                                llenarRegistro();
                            } else if (eleecion.equals("N") || eleecion.equals("n")) {
                                students = null;
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
            System.out.println("Ingresa el nombre completo del estudiante " + (i + 1));
            name = sc.nextLine();
            System.out.println("Fecha de nacimiento (dd/mm/aaaa) " + (i + 1));
            date = sc.nextLine();
            System.out.println("Sexo (Masculino: M, Femenino F, Otro X) " + (i + 1));
            sex = sc.nextLine();
            System.out.println("Carrera " + (i + 1));
            carrer = sc.nextLine();
            if (validarDataRegistro(name, date, sex, carrer)) {
                String[] dateArr = date.split("/");
                int TODAY = 2022;
                students[i] = new Estudiante(name, Integer.parseInt(dateArr[2]) - TODAY, sex, inter.generarID(name, dateArr[0], dateArr[2]), carrer);
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


    public void comenzarJuego(){
    //Falta agregar un metodo que divida a los usuarios en parejas para así continuar
        //juegos[0] = new miniBlackJack();
    //Persona ganador = juegos[0].jugar();
        System.out.println("Comenzando en breves");
        Estudiante [] [] jugadoresD1 = inter.distribuirJugadores(inter.desordenarArreglo(students));
        Estudiante [] [] jugadoresD2 = inter.distribuirJugadores(inter.desordenarArreglo(students));
        Estudiante [] [] jugadoresD3 = inter.distribuirJugadores(inter.desordenarArreglo(students));
        //juegos[0]=new JugarConecta(jugadoresD2);
        juegos[0]= new miniBlackJack(jugadoresD1);
        juegos[0].jugar();
        inter.mostrarMatriz(jugadoresD1);
        /*inter.mostrarMatriz(jugadoresD2);
        inter.mostrarMatriz(jugadoresD3);*/
    }

    public void concursantes() {

    }

    public void partidas() {

    }

    public void listaTorneo() {

    }

    ;
}
