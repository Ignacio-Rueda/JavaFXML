
package generico_1;

import java.util.Comparator;
/**
 * Ordena alfabéticamente.
 * @author Ignacio
 *
 */
public class ComparadorPorLongitudNombre implements Comparator<Alumno> {

    @Override
    public int compare(Alumno a1, Alumno a2) {
    	return Integer.compare(a1.nombre.length(), a2.nombre.length());
    }
    
}
