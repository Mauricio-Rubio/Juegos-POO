package Juegos.BlackJack;
import Clases.*;
import Juegos.Jugar;

public class miniBlackJack extends Jugar {
    private Estudiante [] [] jugadores;
    private Baraja baraja;
    public miniBlackJack(Estudiante [][] jugadores)
    {
        super(jugadores);
        baraja=new Baraja();
    }

    public Estudiante [][] jugar(){
    if(true){
        System.out.println("Hola");
        System.out.println(baraja);
    }
        return null;
    }
}
