/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viviendadomotica;

/**
 *
 * @author Ignacio
 */
public class Cerradura extends Dispositivo{
    private boolean estado;
    //CONSTRUCTOR 3 PARÁMETROS
    public Cerradura(String descripcion,int ubicacion, boolean estado)throws IllegalArgumentException{
        super(descripcion,ubicacion);
        this.estado = estado;
    }
    //CONSTRUCTOR 2 PARÁMETROS
    public Cerradura(String descripcion,int ubicacion) throws IllegalArgumentException{
        this(descripcion,ubicacion,false);
    }

    @Override
    public String toString(){
        return String.format("%s, cuyo estado es %s ", 
                super.toString(),
                this.estado?"Abierta":"Cerrada"
        );
    }
    
    public boolean getEstado(){
        return this.estado;
    }

    
}
