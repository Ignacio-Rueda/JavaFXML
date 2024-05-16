
package generico_1;

import java.util.Comparator;
/**
 * Ordena alfabéticamente.
 * @author Ignacio
 *
 */
public class ComparadorPorNombre implements Comparator<Alumno> {

    @Override
    public int compare(Alumno a1, Alumno a2) {
    	return a1.nombre.compareTo(a2.nombre);
    }
    
}
