package Sistema;

public  class  Interfaz {
    public  String generarID(String nombre, String dia, String year){
        int numero = (int)(Math.random()*1000+1);
        return String.valueOf(numero)+nombre.charAt(0)+nombre.charAt(2)+year.charAt(2)+year.charAt(3);
    }
}
