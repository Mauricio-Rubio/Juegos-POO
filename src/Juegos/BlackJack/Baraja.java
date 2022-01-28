package Juegos.BlackJack;

import java.util.Arrays;

public class Baraja {

    Carta[] cartas;
    int contador =0;

    public Baraja() {
        cartas = new Carta[52];
        String[] palos = {"diamante", "trebol", "picas", "corazon"};
        for (int i = 1; i <= 13; i++) {
            cartas[i - 1] = new Carta(i, "diamante");
            cartas[i + 12] = new Carta(i, "trebol");
            cartas[i + 25] = new Carta(i, "picas");
            cartas[i + 38] = new Carta(i, "corazon");
        }
    }

    public Carta tomarCarta() {
        Carta x;
        x = cartas[contador];
        contador++;
        return x;
    }

    public void revolverBaraja() {
        Carta aux;
        int aleatorio;
        for (int i = 0; i < cartas.length; i++) {
            aleatorio = random(cartas.length) - 1;
            aux = cartas[aleatorio];
            cartas[aleatorio] = cartas[i];
            cartas[i] = aux;
        }
    }

    public boolean compararCartas(Carta c1, Carta c2) {
        if (c1.equals(c2)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Baraja{" +
                "cartas=" + Arrays.toString(cartas) +
                '}';
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    private int random(int max) {
        return (int) Math.round(Math.random() * max + 0.5);
    }

}
