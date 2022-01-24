package Sistema;
import Clases.*;
import java.util.*;
public class Sistema {
    int [] dias = {1,2,3};
    Estudiante [] students;
    Scanner sc = new Scanner(System.in);
    public void iniciar(){
        System.out.println("Bienvenido al torneo");
        menu();
    }

    public void menu(){
        //Aqui debemos preguntar si ya existe un juego en memoria
        if(true == true){
            //iniciar juego precargado
        }else{
            registrar();
        }
    }

    public void registrar(){
        try{
            System.out.println("Ingresa el número de estudiantes");
            students = new Estudiante[sc.nextInt()];
            for(int i = 0; i<students.length; i++){
                System.out.println("");
            }
        }catch (Exception e){

        }

    }


    public void concursantes(){

    }
    public void partidas(){

    }
    public void listaTorneo(){

    };
}
