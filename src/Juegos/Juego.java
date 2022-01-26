package Juegos;
import Clases.*;
public abstract class Juego {
    private Persona p1;
    private Persona p2;

    public Juego(Persona p1, Persona p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Persona getP1() {
        return p1;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }

    public Persona getP2() {
        return p2;
    }

    public void setP2(Persona p2) {
        this.p2 = p2;
    }


    public abstract Persona jugar();

}
