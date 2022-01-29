package Sistema;

import Sistema.Clases.*;
import Sistema.DataBase.DataBase;
import Sistema.Juegos.BlackJack.miniBlackJack;
import Sistema.Juegos.Jugar;

import java.util.*;

public class Sistema {
    int dias = 1;
    protected Estudiante[] students;
    private Jugar[] juegos = new Jugar[3];
    private DataBase dBase = new DataBase();
    public Estudiante[] ganadoresD1;
    public Estudiante[] ganadoresD2;
    public Estudiante[] ganadoresD3;
    private Estudiante[][] jugadoresD1;
    private Estudiante[][] jugadoresD2;
    private Estudiante[][] jugadoresD3;
    Interfaz inter = new Interfaz();
    Scanner sc = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);

    public void iniciar(Estudiante[] students) {
        System.out.println("Bienvenido al torneo");
        this.students = students;
        estado();
    }

    public void estado() {
        //Aqui debemos preguntar si ya existe un juego en memoria
        //System.out.println("Ya existe (S/N)");
        if (dBase.leerEstudiantes() != null) {
            System.out.println("Cargando datos");
            students = dBase.leerEstudiantes();
            /*for (Estudiante es:students) {
                System.out.println(es);
            }*/
            menu();
        } else {
            if (registrar()) {
                System.out.println("Registro exitoso");
                System.out.println("Guardando Jugadores");
                if(dBase.guardarJugadores(students)){
                    System.out.println("Jugadores guardados");
                }else{
                    System.out.println("Error al guardar archivos");
                    return;
                }
                comenzarJuego();
            } else {
                estado();
            }
        }
    }

    public void menu(){
        sc = new Scanner(System.in);
        scInt = new Scanner(System.in);
        int x;
        System.out.println("1.- Concursantes registrados");
        System.out.println("2.- Partidas registradas");
        System.out.println("3.- Lista del torneo");
        System.out.println("4.- Ganadores");
        System.out.println("5.- Salir");
        String elec = sc.nextLine();
        try {
            x=Integer.parseInt(elec);
            switch (x){
                case 1:
                    mostrarRegistro();
                    menu();
                    break;
                case 2:
                    mostrarPartidas();
                    menu();
                    break;
                case 3:
                    mostrarParejas();
                    break;
                case 4:
                    campeon();
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
                default:
                    throw new Exception("Deja de joder");
            }
        }catch (Exception e){
            System.out.println("Debes ingresar una opción valida");
            //System.out.println(e.getMessage());
        }
        
    }
    public void mostrarRegistro(){
        for (Estudiante es:students) {
            System.out.println(es);
        }
    }
    public void mostrarPartidas(){
        ganadoresD1 = dBase.leerPartidas();
        jugadoresD1 = dBase.leerPartidasJugadores();
        if(ganadoresD1!=null && jugadoresD1 != null){
            System.out.println("Mostrando rivales");
            inter.mostrarMatrizRiv(jugadoresD1);
            System.out.println("Mostrando ganadores");
            inter.mostrarArreglo(ganadoresD1);

        }if(ganadoresD2!=null){
            inter.mostrarArreglo(ganadoresD2);
        }if(ganadoresD3 != null){
            inter.mostrarArreglo(ganadoresD3);
        }

    }
    public void mostrarParejas(){

    }
    public void campeon(){

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
                    if (students != null) {
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


    public void comenzarJuego() {
        //Falta agregar un metodo que divida a los usuarios en parejas para así continuar
        //juegos[0] = new miniBlackJack();
        //Persona ganador = juegos[0].jugar();
        System.out.println("Comenzando en breves");
        //jugadoresD2 = inter.distribuirJugadores(inter.desordenarArreglo(students));
        //jugadoresD3 = inter.distribuirJugadores(inter.desordenarArreglo(students));
        String elec="";
        if(dias == 1){
            jugarD1();
            System.out.println("Estos son los ganadores");
            inter.mostrarArreglo(ganadoresD1);
            System.out.println("Juego ha terminado");
            System.out.println("Guardando los resultados");
            dBase.guardarGanadores(ganadoresD1);
            //dBase.guardarGanadores(ganadoresD2);
            do{
                System.out.println("¿Desea continuar al siguiente dia? (S/N)");
                elec = sc.nextLine();
                if(elec.equals("S") || elec.equals("s")){
                    dias++;
                    break;
                }
            }while(! (elec.equals("s")) || ! (elec.equals("S")));
        }
        if(dias == 2){
            //jugarD1();
            System.out.println("Se jugo conecta");
            do{
                System.out.println("¿Desea continuar al siguiente dia? (S/N)");
                elec = sc.nextLine();
                if(elec.equals("S") || elec.equals("s")){
                    dias++;
                    break;
                }
            }while(! (elec.equals("s")) || ! (elec.equals("S")));
        }
        if(dias == 3){
            System.out.println("Se jugó dados");
        }
        estado();

        //inter.mostrarMatriz(jugadoresD1);
        /*inter.mostrarMatriz(jugadoresD2);
        inter.mostrarMatriz(jugadoresD3);*/
    }
    public void jugarD1(){
        jugadoresD1 = inter.distribuirJugadores(inter.desordenarArreglo(students));
        System.out.println("Guardando las partidas");
        dBase.guardarPartidas(jugadoresD1);
        //ganadores = new Estudiante[1][jugadoresD1[0].length];
        juegos[0] = new miniBlackJack(jugadoresD1);
        ganadoresD1 = juegos[0].jugar();
    }


    public void concursantes() {

    }

    public void partidas() {

    }

    public void listaTorneo() {

    }

    ;
}
