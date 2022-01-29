package Sistema.Juegos.BlackJack;

import Sistema.Clases.*;
import Sistema.Juegos.Jugar;

public class miniBlackJack extends Jugar {
    //private Estudiante [] [] jugadores;
    private Baraja baraja;
    private IABlackJack IA = new IABlackJack();

    public miniBlackJack(Estudiante[][] jugadores) {
        super(jugadores);
        this.jugadores = jugadores;
        //baraja=new Baraja();
    }

    public Estudiante[] jugar() {
        int PARTIDAS = jugadores[0].length;
        Estudiante [] ganadores;
        boolean noContest=false;
        System.out.println("Partidas por simular--->" + PARTIDAS);
        ganadores = new Estudiante[PARTIDAS];
        //System.out.println("c1-->"+baraja.tomarCarta());
        //System.out.println("c2-->"+baraja.tomarCarta());
        for (int i = 1; i <= PARTIDAS; i++) {
            System.out.println("\nSimulando partida " + i);
            baraja = new Baraja();
            baraja.revolverBaraja();
            Carta j1 = baraja.tomarCarta(), j11, j2 = baraja.tomarCarta(), j21;
            System.out.println("Jugador " + jugadores[0][i - 1].getId() + " tiene la carta " + j1);
            System.out.print("Jugador " + jugadores[1][i - 1].getId() + " tiene la carta " + j2+"\n");
            //System.out.print(elegir(jugadores[0][i - 1]));
            int manoJ1, manoJ2;
            if (!elegir(jugadores[0][i - 1])) {
                manoJ1 = j1.obtenerValor();
            } else {
                j11 = baraja.tomarCarta();
                System.out.println("Jugador " + jugadores[0][i - 1].getId() + " tiene la carta " + j11);
                manoJ1 = j1.obtenerValor() + j11.obtenerValor();
            }
            if (!elegir(jugadores[1][i - 1])) {
                manoJ2 = j2.obtenerValor();
                //System.out.print("\nJugador " + jugadores[0][i - 1].getId() + " tiene la mano: " + manoJ1);
            } else {
                j21 = baraja.tomarCarta();
                System.out.println("Jugador " + jugadores[1][i - 1].getId() + " tiene la carta " + j21);
                manoJ2 = j2.obtenerValor() + j21.obtenerValor();
            }
            int winCond = ganador(manoJ1, manoJ2);
            Estudiante winner = null;
            switch (winCond) {
                case 0:
                    winner = jugadores[1][i - 1];
                    break;
                case 1:
                    winner = jugadores[0][i - 1];
                    break;
                case 2:

                    winner = jugadores[0][i - 1];
                    break;
                case 3:
                    winner = jugadores[1][i - 1];
                    break;
                case 4:
                    System.out.println("empate");
                    noContest = true;
            }
            if(noContest){
                System.out.println("Han empatado");
            }else{
                System.out.println("Jugador " + winner.getId() + " ha ganado ");
                ganadores[i-1]=winner;
            }



        }
        return ganadores;
    }

    public boolean elegir(Estudiante jugador) {
        int aleatorio = IA.random2();
        if (aleatorio == 2) {
            System.out.println("Jugador " + jugador.getId() + " ha decidido quedarse");
            return true;
        } else if (aleatorio == 1) {
            System.out.println("Jugador " + jugador.getId() + " ha decidido salir");
        }
        return false;
    }

    public int ganador(int mano1, int mano2) {
        int n = 0;
        if (mano1 > 21 && mano2 <= 21) {
            return 0;
        } else if (mano2 > 21 && mano1 <= 21) {
            return 1;
        } else if (mano1 > mano2) {
            return 2;
        } else if (mano2 > mano1) {
            return 3;
        } else {
            return 4;
        }
    }
}
