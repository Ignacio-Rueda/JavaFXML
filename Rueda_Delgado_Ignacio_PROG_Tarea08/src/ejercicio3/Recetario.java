package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un recetario para la gestión de recetas.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar una lista de objetos de tipo
 * <strong>Receta</strong>.
 * @author profe
 */
public class Recetario {

    // -------------------------------------------------------------------------
    // ATRIBUTOS DE OBJETO
    // ------------------------------------------------------------------------
    private List<Receta> recetas; // Lista de objetos Receta 
    
    // ------------------------------------------------------------------------
    //                        CONSTRUCTOR
    // ------------------------------------------------------------------------
    /**
     * Crea un objeto CRecetario vacío.
     */
    public Recetario(){
        recetas = new ArrayList<>();
    }

    /**
     * Asigna al recetario un listado de recetas que se pasa por parámetro.
     * @param recetas Lista de objetos de tipo Receta.
     */
    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
    
    /**
     * Añade una nueva receta al recetario.
     * @param nueva Objeto de tipo Receta que se añade
     * @throws NullPointerException si el parámetro es nulo.
     */
    public void add(Receta nueva) throws NullPointerException {
        if (nueva == null)
             throw new NullPointerException ("El objeto Receta no puede ser nulo.");
        
        recetas.add(nueva); 
    }
     
   /**
    * Busca una receta en el recetario a partir de su nombre.
    * @param nombre Nombre de la receta que estamos buscando
    * @return si la receta se encuentra o no en el recetario
    * @throws NullPointerException si el parámetro es nulo    
    */
    public boolean buscarPorNombre(String nombre) throws NullPointerException {
        if (nombre == null)
            throw new NullPointerException ("El nombre de la receta no puede ser nulo.");
        
        boolean encontrado = false;
        for (int i = 0; i < recetas.size() && !encontrado; i++) {
            if (recetas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    /**
     * Obtiene el número de recetas del recetario.
     * @return número de recetas
     */
    public int numRecetas() {
        return recetas.size();
    }
    
    /**
     * Permite borrar una receta del recetario.
     * @param borrada Objeto de tipo Receta que queremos borrar
     * @return si la receta ha sido eliminada
     * @throws NullPointerException si el parámetro es nulo
     */
    public boolean borrarReceta(Receta borrada) throws NullPointerException {
        if (borrada == null)
            throw new NullPointerException ("El objeto CReceta no puede ser nulo.");
        
        return recetas.remove(borrada);
    }
    
    /**
     * Permite vaciar el recetario de recetas.
     */
    public void vaciarRecetario() {
        recetas.clear();
    }
    
    /**
     * Devuelve una cadena que representa las características del recetario de 
     * forma textual.
     * @return cadena que representa las características del recetario de forma textual
     */
    @Override
    public String toString() {
        String listado = "";

        if (recetas.isEmpty()) {
            listado = "El recetario está vacío";
        } else {
            for (Receta r : recetas) {
                listado = listado + r.toString()+"\n";
            }
        }
        return listado;
    }
}
