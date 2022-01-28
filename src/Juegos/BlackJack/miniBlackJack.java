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
        Carta c1= baraja.tomarCarta();
        Carta c2= baraja.tomarCarta();
        System.out.println("Comparando Cartas");
        //baraja.revolverBaraja();
        System.out.println(baraja.compararCartas(c1,c2));
    }
        return null;
    }
}
