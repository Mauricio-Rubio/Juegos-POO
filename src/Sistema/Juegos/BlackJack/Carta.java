package Sistema.Juegos.BlackJack;

public class Carta {
    private final int valor;
    private final int figura;
    public final String[] figuras;
    public final String[] valores;

    /**
     * Carta
     * @param n
     * @param n2
     */
    public Carta(final int n, final int n2) {
        this.figuras = new String[]{null, "diamante", "trebol", "corazon", "picas"};
        this.valores = new String[]{null, "as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "J", "Q", "K"};
        this.valor = ((n > 0 && n < 14) ? n : 0);
        this.figura = ((n2 > 0 && n2 < 5) ? n2 : 0);
    }

    /**
     * Carta
     * @param n
     * @param str
     */
    public Carta(final int n, final String str) {
        this.figuras = new String[]{null, "diamante", "trebol", "corazon", "picas"};
        this.valores = new String[]{null, "as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "J", "Q", "K"};
        this.valor = ((n > 0 && n < 14) ? n : 0);
        this.figura = this.esFiguraValida(str);
        if (this.figura == 0) {
            System.out.println("La figura " + str + " es incorrecta.");
        }
    }

    /**
     * Carta
     * @param str
     * @param str2
     */
    public Carta(final String str, final String str2) {
        this.figuras = new String[]{null, "diamante", "trebol", "corazon", "picas"};
        this.valores = new String[]{null, "as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "J", "Q", "K"};
        this.valor = this.esValorValido(str);
        if (this.valor == 0) {
            System.out.println("El valor " + str + " es incorrecto.");
        }
        this.figura = this.esFiguraValida(str2);
        if (this.figura == 0) {
            System.out.println("La figura " + str2 + " es incorrecta.");
        }
    }
    /**
     * ObtenerFigura
     * @return int
     */
    public int obtenerFigura() {
        return this.figura;
    }
    /**
     * Obtener Nombre Figura
     * @return String
     */
    public String obtenerNombreFigura() {
        if (this.figura > 0 && this.figura < 5) {
            return this.figuras[this.figura];
        }
        return null;
    }
    /**
     * obtener nombre valor
     * @return Strig
     */
    public String obtenerNombreValor() {
        if (this.valor > 0 && this.valor < 14) {
            return this.valores[this.valor];
        }
        return null;
    }

    /**
     * obtener valor
     * @return int
     */
    public int obtenerValor() {
        return this.valor;
    }
    /**
     * es valor valido
     * @param lowerCase
     * @return int
     */
    public int esValorValido(String lowerCase) {
        lowerCase = lowerCase.trim().toLowerCase();
        for (int i = 1; i < this.valores.length; ++i) {
            if (this.valores[i].equals(lowerCase)) {
                return i;
            }
        }
        return 0;
    }
    /**
     * Es figura valida
     * @param lowerCase
     * @return
     */
    public int esFiguraValida(String lowerCase) {
        lowerCase = lowerCase.trim().toLowerCase();
        for (int i = 1; i < this.figuras.length; ++i) {
            if (this.figuras[i].equals(lowerCase)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(final Object o) {
        final Carta carta = (Carta) o;
        return this.valor == carta.valor && this.figura == carta.figura;
    }

    @Override
    public String toString() {
        return this.valores[this.valor] + " de " + this.figuras[this.figura]+"\n";
    }

    /*public static void main(final String[] array) {
        final Carta[] array2 = new Carta[52];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = new Carta(i % 13 + 1, i / 13 + 1);
            System.out.println(array2[i]);
        }
    }*/
}
