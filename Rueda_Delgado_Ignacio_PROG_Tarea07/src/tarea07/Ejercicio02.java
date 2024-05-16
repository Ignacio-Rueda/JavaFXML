package tarea07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

/**
 * Ejercicio 2. Búsqueda de especies de plantas populares
 *
 * @author Ignacio Rueda Delgado.
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        int CANTIDAD_ESPECIES_PLANTAS = 10;
        // Variables de entrada

        // Variables auxiliares
        List<String> lista1 = new LinkedList<>();
        List<String> lista2 = new LinkedList<>();
        List<String> plantasPopulares = new LinkedList<>();
        List<Integer> posicionesPopulares = new LinkedList<>();
        Set<String> conjuntoPlantasPopulares = new HashSet<>();
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("BÚSQUEDA DE ESPECIES DE PLANTAS POPULARES");
        System.out.println("-----------------------------------------");

        // No hay, pues se usa un número fijo de elementos aleatorios
        //PRUEBAS EJERCICIO
        /*
        String planta1[] = {"SUCULENTA", "BULBO", "ARBUSTO", "SUCULENTA", "BULBO", "GRAMINEA", "BULBO", "PERENNE", "ARBUSTO", "SUCULENTA"};
        String planta2[] = {"BULBO", "BULBO", "GRAMINEA", "PERENNE", "BULBO", "BULBO", "ARBUSTO", "PERENNE", "PERENNE", "BULBO"};
        String planta3[] = {"ARBOL", "HORTALIZA", "BULBO", "ARBUSTO", "SUCULENTA", "FLOR", "GRAMINEA", "SUCULENTA", "PERENNE", "HORTALIZA"};
        String planta4[] = {"GRAMINEA", "GRAMINEA", "GRAMINEA", "HORTALIZA", "GRAMINEA", "ARBOL", "PERENNE", "PERENNE", "BULBO", "ARBOL"};
         */
        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        for (int n = 0; n < CANTIDAD_ESPECIES_PLANTAS; n++) {
            lista1.add(Utilidades.especiePlantaAleatoria());
            lista2.add(Utilidades.especiePlantaAleatoria());
        }
        System.out.printf("1. Contenido inicial de la lista 1: %s%n", lista1);
        System.out.printf("2. Contenido inicial de la lista 2: %s%n%n", lista2);
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        // Recorremos a la vez las dos listas
        Iterator<String> it = lista1.listIterator();
        int pos = 0;
        while (it.hasNext()) {

            //Si existe coincidencia
            if (it.next().equals(lista2.get(pos))) {
                plantasPopulares.add(lista1.get(pos));
                conjuntoPlantasPopulares.add(lista1.get(pos));
                posicionesPopulares.add(pos);
                lista2.set(pos, "*" + lista1.get(pos) + "*");
                lista1.set(pos, "*" + lista1.get(pos) + "*");
            }
            pos++;
        }
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------

        System.out.printf("1. Contenido final de la lista 1: %s%n", lista1);
        System.out.printf("2. Contenido final de la lista 2: %s%n", lista2);
        System.out.printf("3. Contenido final de la lista de especies de plantas populares: %s%n", plantasPopulares);
        System.out.printf("4. Contenido final de la lista de posiciones populares: %s%n", posicionesPopulares);
        System.out.printf("5. Contenido final del conjunto de especies de plantas populares: %s%n", conjuntoPlantasPopulares);

    }
}
