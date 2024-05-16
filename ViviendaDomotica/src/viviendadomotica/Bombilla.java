/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viviendadomotica;

/**
 *
 * @author Ignacio
 */
public class Bombilla extends Dispositivo {

    private int intensidad;
    public static final int MIN_INTENSIDAD = 0;
    public static final int MAX_INTENSIDAD = 10;
    int numVecesManipulada;

    private Bombilla(String descripcion, int ubicacion, int intensidad) throws IllegalArgumentException {
        super(descripcion, ubicacion);
        this.numVecesManipulada = 0;
        this.intensidad = intensidad;
    }

    
    public static Bombilla crearBombilla(String descripcion, int ubicacion, int intensidad) throws IllegalArgumentException {
          if (intensidad < Bombilla.MIN_INTENSIDAD || intensidad > Bombilla.MAX_INTENSIDAD) {
            throw new IllegalArgumentException("Error al crear la bombilla");
        }
        Bombilla b = new Bombilla(descripcion,ubicacion,intensidad);
        return b;
    }
    @Override
    public String toString(){
        return String.format("%s,CON UNA INTENSIDAD : %d",
                super.toString(),
                this.intensidad
        );
    }

}
