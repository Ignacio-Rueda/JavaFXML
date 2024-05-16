package tarea07;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/**
 * Ejercicio 1. Creando jardín botánico
 *
 * @author Ignacio Rueda Delgado
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        int CANTIDAD_ESPECIES_PLANTAS = 5;//Cantidad de especies de plantas aleatorias.
        // Variables de entrada

        // Variables auxiliares
        Set<String> conjunto1 = new HashSet<>();
        Set<String> conjunto2 = new HashSet<>();
        Set<String> conjunto3 = new HashSet<>();
        Set<String> conjunto4 = new HashSet<>();
        Set<String> conjunto5 = new HashSet<>();

        // Variables de salida
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay, pues se usa un número fijo de elementos aleatorios
        System.out.println("CONJUNTOS DE ESPECIES DE PLANTAS");
        System.out.println("--------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Rellenamos los conjuntos con especies de plantas aleatorias hasta que haya CANTIDAD_ESPECIES_PLANTAS
        while (conjunto1.size() < CANTIDAD_ESPECIES_PLANTAS) {
            conjunto1.add(Utilidades.especiePlantaAleatoria());
        }
        while (conjunto2.size() < CANTIDAD_ESPECIES_PLANTAS) {
            conjunto2.add(Utilidades.especiePlantaAleatoria());
        }
        /*Otra manera de añadir elementos a los conjuntos es con un iterador.
        Iterator<String> it = conjunto1.iterator();
        while (it.hasNext()) {
            String planta = it.next();
            conjunto3.add(planta);
            conjunto4.add(planta);
            conjunto5.add(planta);

        }*/
        for (String planta : conjunto1) {
            conjunto3.add(planta);
            conjunto4.add(planta);
            conjunto5.add(planta);
        }
        // Unión de los dos conjuntos
        conjunto3.addAll(conjunto2);

        // Intersección de los conjuntos
        conjunto4.retainAll(conjunto2);

        // Diferencia de los conjuntos
        conjunto5.removeAll(conjunto2);
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        // Recorremos el conjunto y mostramos su contenido por pantalla
        System.out.printf("Conjunto C1: %s%n", conjunto1);
        System.out.printf("Conjunto C2: %s%n", conjunto2);
        System.out.printf("Unión C1 y C2: %s%n", conjunto3);//Todos los del conjunto1 añadiendo los del conjunto2, pero sin repetir los que ya están.
        System.out.printf("Intersección C1 y C2: %s%n", conjunto4);//Todos los elementos del conjunto1, que también están en el conjunto2.
        System.out.printf("Diferencia C2-C1: %s%n", conjunto5);//Todos los elementos del conjunto1, que no estén el conjunto2.

    }
}
