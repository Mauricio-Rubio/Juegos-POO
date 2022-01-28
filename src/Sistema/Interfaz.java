package Sistema;

import Clases.Estudiante;

public  class  Interfaz {
    public  String generarID(String nombre, String dia, String year){
        int numero = (int)(Math.random()*1000+1);
        return String.valueOf(numero)+nombre.charAt(0)+nombre.charAt(2)+year.charAt(2)+year.charAt(3);
    }
    public String generarID(String nombre){
        int numero = (int)(Math.random()*1000+1);
        return String.valueOf(numero)+nombre.charAt(0)+nombre.charAt(1);
    }

    public Estudiante [] [] distribuirJugadores(Estudiante [] students){
        Estudiante [] [] studentsRepartition;
        int modulo = students.length % 2;
        if(modulo == 0){
            System.out.println("Es par");
            studentsRepartition = new Estudiante[2][students.length/2];
            for(int i = 0; i<studentsRepartition[0].length; i++){
                studentsRepartition[0][i] = students[2*i];
                studentsRepartition[1][i] = students[(2*(i+1))-1];
            }
        }else{
            System.out.println("Es impar");
            studentsRepartition = new Estudiante[2][(students.length+1)/2];
            for(int i = 0; i<studentsRepartition[0].length; i++){
                studentsRepartition[0][i]=students[2*i];
            }
            for(int i = 0; i<studentsRepartition[0].length-1; i++){
                studentsRepartition[1][i] = students[(2*(i+1))-1];
            }
            studentsRepartition[1][(students.length-1)/2] = new Estudiante("IA",generarID("IA"));
        }return studentsRepartition;
    }
}
