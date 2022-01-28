package Sistema;

import Clases.Estudiante;

public  class  Interfaz {
    public  String generarID(String nombre, String dia, String year){
        int numero = (int)(Math.random()*1000+1);
        return String.valueOf(numero)+nombre.charAt(0)+nombre.charAt(2)+year.charAt(2)+year.charAt(3);
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
                //System.out.println(students[(2*(i+1))-1]);
            }
        }else{
            System.out.println("Es impar");
            studentsRepartition = new Estudiante[students.length+1/2][2];
            for(int i = 0; i<studentsRepartition.length; i++){
                System.out.println(2*i);
                //studentsRepartition[0][i] = students[2*i];
                //System.out.println(studentsRepartition[0][i]);
                //studentsRepartition[1][i] = students[(2*(i+1))-1];
                //System.out.println(students[(2*(i+1))-1]);
            }
        }return studentsRepartition;
    }
}
