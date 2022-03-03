package Sistema.Juegos;
import Sistema.Clases.*;
public abstract class Jugar {
   protected Estudiante [][] jugadores;
    /**
     * Jugar
     * @param jugadores
     */
    public Jugar(Estudiante [] [] jugadores) {
        this.jugadores = jugadores;
    }
    /**
     * jugar
     * @return Estudiante []
     */
    public abstract Estudiante []  jugar();

}
