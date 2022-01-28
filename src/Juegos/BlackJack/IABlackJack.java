package Juegos.BlackJack;

public class IABlackJack  {
    public int random2() {
        //int n = (int) (Math.random() * (<número_máximo + 1> - <número_mínimo>)) + <numero_mínimo>;
        return (int) (Math.random() * (2 + 1 - 1)) + 1;
    }
}
