package ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una receta para un recetario.
 */
public class Receta {

     // ------------------------------------------------------------------------
    // ATRIBUTOS DE OBJETO
    // ------------------------------------------------------------------------
    // Atributos de objeto variables
    private String nombre; // Nombre de la receta
    private String tipoPlato; // Tipo de plato: Postre, Ensalada, etc.
    private List<String> ingredientes; // Lista de ingredientes
    private String instrucciones; // Instrucciones para preparar la receta 
    private LocalDate fechaCreacion; // Fecha de creación de la receta

    // ------------------------------------------------------------------------
    //                        CONSTRUCTOR
    // ------------------------------------------------------------------------
    /**
     * Crea un objeto CReceta con un nombre, tipo de plato, lista de
     * ingredientes, instrucciones y fecha de creación.
     *
     * @param nombre Nombre de la receta
     * @param tipoPlato Tipo de plato de la receta
     * @param ingredientes Lista de ingredientes de la receta
     * @param instrucciones Instrucciones para preparar la receta
     * @param fechaCreacion Fecha de creación de la receta
     */
    public Receta(String nombre, String tipoPlato, LocalDate fechaCreacion, List<String> ingredientes, String instrucciones)
            throws NullPointerException {
        this.setNombre(nombre);
        this.setTipoPlato(tipoPlato);
        this.setIngredientes(ingredientes);
        this.setInstrucciones(instrucciones);
        this.setFechaCreacion(fechaCreacion);
    }

    // ------------------------------------------------------------------------
    //                        GETTERS Y SETTERS
    // ------------------------------------------------------------------------
    /**
     * Devuelve el nombre de la receta.
     *
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el tipo de plato de la receta
     *
     * @return tipo de plato
     */
    public String getTipoPlato() {
        return this.tipoPlato;
    }

    /**
     * Devuelve la lista de ingredientes de la receta
     *
     * @return lista de ingredientes
     */
    public List<String> getIngredientes() {
        // Devolvemos una copia de la lista para evitar modificaciones externas
        return new ArrayList<>(this.ingredientes);
    }

    /**
     * Devuelve las instrucciones para preparar la receta
     *
     * @return instrucciones
     */
    public String getInstrucciones() {
        return this.instrucciones;
    }

    /**
     * Devuelve la fecha de creación de la receta
     *
     * @return fecha de creación
     */
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    /**
     * Asigna un nombre a la receta.
     *
     * @param nombre Nombre que se va a asignar a la receta
     * @throws NullPointerException si el parámetro nombre es nulo
     */
    public void setNombre(String nombre) throws NullPointerException {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo.");
        }
        this.nombre = nombre;
    }

    /**
     * Asigna un tipo de plato a la receta.
     *
     * @param tipoPlato Tipo de plato que se va a asignar a la receta
     * @throws NullPointerException si el parámetro tipoPlato es nulo
     */
    public void setTipoPlato(String tipoPlato) throws NullPointerException {
        if (tipoPlato == null) {
            throw new NullPointerException("El tipo de plato no puede ser nulo.");
        }
        this.tipoPlato = tipoPlato;
    }

    /**
     * Asigna una lista de ingredientes a la receta.
     *
     * @param ingredientes Lista de ingredientes que se va a asignar a la receta
     * @throws NullPointerException si el parámetro ingredientes es nulo
     */
    public void setIngredientes(List<String> ingredientes) throws NullPointerException {
        if (ingredientes == null) {
            throw new NullPointerException("La lista de ingredientes no puede ser nula.");
        }
        this.ingredientes = new ArrayList<>(ingredientes);
    }

    /**
     * Asigna las instrucciones para preparar la receta.
     *
     * @param instrucciones Instrucciones que se van a asignar a la receta
     * @throws NullPointerException si el parámetro instrucciones es nulo
     */
    public void setInstrucciones(String instrucciones) throws NullPointerException {
        if (instrucciones == null) {
            throw new NullPointerException("Las instrucciones no pueden ser nulas.");
        }
        this.instrucciones = instrucciones;
    }

    /**
     * Asigna una fecha de creación a la receta.
     *
     * @param fechaCreacion Fecha de creación que se va a asignar a la receta
     * @throws NullPointerException si el parámetro fechaCreacion es nulo
     */
    public void setFechaCreacion(LocalDate fechaCreacion) throws NullPointerException {
        if (fechaCreacion == null) {
            throw new NullPointerException("La fecha de creación no puede ser nula.");
        }
        this.fechaCreacion = fechaCreacion;
    }

    //-------------------------------------------------------------------------
    //                         MÉTODO TOSTRING
    //-------------------------------------------------------------------------
    /**
     * Devuelve una cadena que representa las características de la receta de
     * forma textual.
     *
     * @return cadena que representa las características de la receta de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("#%s;%s;%s;%s;%s;",
                this.nombre, this.tipoPlato, this.fechaCreacion,this.ingredientes, this.instrucciones);
    }
}
