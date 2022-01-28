package Juegos.BlackJack;

import java.util.Arrays;

public class Baraja {


    Carta[] cartas;

    public Baraja() {
        cartas = new Carta[52];
        for (int i = 0; i < cartas.length; i++) {
            if (i <= 12) {
                cartas[i] = new Carta(i + 1, "corazon");
            }
            if (i > 12 && i <= 26) {
                cartas[i] = new Carta(((i + 1) % 13) == 0 ? 13 : ((i + 1) % 13), "diamante");
            }
        }
    }

    @Override
    public String toString() {
        return "Baraja{" +
                "cartas=" + Arrays.toString(cartas) +
                '}';
    }

}
