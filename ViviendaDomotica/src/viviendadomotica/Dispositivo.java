/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viviendadomotica;

/**
 *
 * @author Ignacio
 */
public abstract class Dispositivo {
   private String descripcion;
   private int ubicacion;
   private int id;
   private static int contadorId;
   public static final int MIN_UBICACION = 1;
   public static final int MAX_UBICACION = 10;

    public Dispositivo(String descripcion,int ubicacion)throws IllegalArgumentException{
        if(ubicacion<Dispositivo.MIN_UBICACION || ubicacion > Dispositivo.MAX_UBICACION){
            throw new IllegalArgumentException("No es posible implementar la ubicación introducida");
        }
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.id = ++contadorId;    
    }

  public String toString(){
     return String.format("%s DESCRIPCIÓN: %s, UBICACIÓN %s,IDENTIFICADOR: %d", 
             this.getClass().getSimpleName(),
             this.descripcion,
             this.ubicacion,
             this.id
     );
  
  }  
  public String getDescripcion(){
      return this.descripcion;
  }
  
  public int getUbicacion(){
      return this.ubicacion;
  }
}
