package Juegos.Conecta4;

import Clases.Estudiante;
import Juegos.Jugar;

public class JugarConecta extends Jugar {
    Estudiante[][] jugadores;
    Conecta4 conecta4 = new Conecta4();
    boolean fin;

    public JugarConecta(Estudiante[][] jugadores) {
        super(jugadores);
    }

    public Estudiante [] [] jugar(){
        System.out.println(jugadores.length);
        //        int partidasAJugar=jugadores[0].length;
  /*      for(int i=0; i<partidasAJugar; i++){
            Estudiante jugador1=jugadores[0][i];
            Estudiante jugador2=jugadores[1][i];
            int primerTirador = (int)(Math.random()*2+1);
            System.out.println(primerTirador);
        }*/


        return null;
    }


}
