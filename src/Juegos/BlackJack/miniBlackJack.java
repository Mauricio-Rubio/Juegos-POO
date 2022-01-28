package Juegos.BlackJack;
import Clases.*;
import Juegos.Jugar;
import jdk.swing.interop.SwingInterOpUtils;

public class miniBlackJack extends Jugar {
    //private Estudiante [] [] jugadores;
    private Baraja baraja;
    public miniBlackJack(Estudiante [][] jugadores)
    {
        super(jugadores);
        this.jugadores = jugadores;
        //baraja=new Baraja();
    }

    public Estudiante [][] jugar(){
        int PARTIDAS = jugadores[0].length;
        System.out.println("Partidas por simular--->"+PARTIDAS);
        //System.out.println("c1-->"+baraja.tomarCarta());
        //System.out.println("c2-->"+baraja.tomarCarta());
        for(int i = 1; i<= PARTIDAS; i++){
            System.out.println("Simulando partida "+i);
            baraja=new Baraja();
            baraja.revolverBaraja();
            System.out.print("Jugador "+jugadores[0][i-1].getId()+" tiene la carta "+baraja.tomarCarta());
            System.out.println("Jugador "+jugadores[1][i-1].getId()+" tiene la carta "+baraja.tomarCarta());
            //System.out.println();
        }
        return null;
    }
}
