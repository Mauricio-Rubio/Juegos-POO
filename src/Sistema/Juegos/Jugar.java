package Sistema.Juegos;
import Sistema.Clases.*;
public abstract class Jugar {
   protected Estudiante [][] jugadores;

    public Jugar(Estudiante [] [] jugadores) {
        this.jugadores = jugadores;
    }

    public abstract Estudiante []  jugar();

}
