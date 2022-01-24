package Clases;

public class Estudiante extends Persona {
    private String carrera;
    private String id;

    public Estudiante(String nombre, int edad, String sexo, String id, String carrera){
        super(nombre,sexo,edad);

    }
}
