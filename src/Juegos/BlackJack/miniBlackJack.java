package Juegos.BlackJack;
import Clases.*;
import Juegos.Jugar;

public class miniBlackJack extends Jugar {
    //private Estudiante [] [] jugadores;
    private Baraja baraja;
    public miniBlackJack(Estudiante [][] jugadores)
    {
        super(jugadores);
        this.jugadores = jugadores;
        baraja=new Baraja();
    }

    public Estudiante [][] jugar(){
        int PARTIDAS = jugadores[0].length;
        System.out.println("Partidas por simular--->"+PARTIDAS);
        for(int i = 1; i<= PARTIDAS; i++){
            System.out.println("Simulando partida "+i);
        }
        return null;
    }
}
