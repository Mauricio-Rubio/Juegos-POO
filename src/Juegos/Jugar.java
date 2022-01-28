package Juegos;
import Clases.*;
public abstract class Jugar {
    private Estudiante [][] jugadores;

    public Jugar(Estudiante [] [] jugadores) {
        this.jugadores = jugadores;
    }

    public abstract Estudiante [] []  jugar();

}
