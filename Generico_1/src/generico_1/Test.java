package generico_1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String args[]) {
		final int NUMERO_ALUMNOS = 9;
		/**
		 * La clase Alumno, tiene implementados tanto el método equals, como hashCode
		 * (ambos necesarios), para determinar si un objeto es igual que otro y por
		 * tanto poder determinar si ese objeto puede ser insertado en el set o no.
		 * 
		 * Por otra parte, pretendo utilizar la clase Collections, con el método
		 * estático sort, para ordenar el objeto "Alumno" bajo el criterio:edad. Es por
		 * ello obligatorio, que dicha clase implemente la interfaz Comparable y su
		 * método correspondiente.
		 * 
		 * PROBLEMA: Cuando trato de introducir nombres de manera en el Set, introduce
		 * nombres repetidos. ¿Por qué? "Constructs a new, empty tree set, *sorted
		 * according to the natural ordering of its elements.*" Ese orden natural es el
		 * que se ha determinado en la clase Alumno.(Criterio edad), por eso introduce
		 * nombres repetidos aunque no edades.
		 * 
		 * POSIBLE SOLUCIÓN: Cuando creamos el Set, le indicaremos cuál será el criterio
		 * que ha de seguir para comparar/ordenar los objetos de tipo Alumno.
		 */
		// Crear una lista de tipo alumnos.
		Set<Alumno> listaAlumnos = new TreeSet<>(new ComparadorPorNombre());
		// Insertar datos en la lista.
		while (listaAlumnos.size() < NUMERO_ALUMNOS) {
			listaAlumnos.add(new Alumno(Utils.nombreAzar(), Utils.edades()));
		}
		System.out.println("MOSTRAR ALUMNOS TAL Y COMO SE ENCUENTRAN EN EL TREESET");
		System.out.println("--------------------------------------------------------");
		Iterator<Alumno> it = listaAlumnos.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("MOSTRAR ALUMNOS ATENDIENDO AL 'ORDEN NATURAL'(edad) DE LA CLASE");
		System.out.println("----------------------------------");
		/**
		 * Dado que quiero utilizar Collections para ordenar el set, debo crear una lista y pasarle el set.
		 * Recuerda que Collections.sort, sólo admite listas.
		 */
		List<Alumno> listaParaConvertir_1 = new LinkedList<>();
		listaParaConvertir_1.addAll(listaAlumnos);
		Collections.sort(listaParaConvertir_1);
		// Utilizar iterator.
		ListIterator<Alumno> itL = listaParaConvertir_1.listIterator();
		while (itL.hasNext()) {
			System.out.println(itL.next().toString());
		}

		System.out.println();
		System.out.println(
				"MOSTRAR ALUMNOS ATENDIENDO AL CRITERIO: LONGITUD NOMBRES \'ComparadorPorLongitudNombre\' que implementa \'Comparator\')");
		System.out.println("----------------------------");
		List<Alumno> listaParaConvertir_2 = new LinkedList<>();
		listaParaConvertir_2.addAll(listaAlumnos);
		Collections.sort(listaParaConvertir_2,new ComparadorPorLongitudNombre());
		ListIterator<Alumno> itL2 = listaParaConvertir_2.listIterator();
		while (itL2.hasNext()) {
			System.out.println(itL2.next());
		}

	}

}
