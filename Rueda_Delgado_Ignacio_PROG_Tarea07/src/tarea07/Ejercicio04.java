package tarea07;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Ejercicio 4. Clasificación de especies de plantas coincidentes (con el mismo
 * nombre y en la misma posición)
 *
 * @author Ignacio Rueda Delgado.
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        int NUM_PLANTAS = 20;
        // Variables de entrada

        // Variables auxiliares
        List<String> lista1 = new LinkedList<>();
        List<String> lista2 = new LinkedList<>();
        Map<String, List<Integer>> diccionarioPlantas = new HashMap<>();
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");
        //PRUEBAS EJERCICIO
        /*
        String array1[] = {"PERENNE", "SUCULENTA", "ARBOL", "PERENNE", "HORTALIZA", "ARBUSTO", "HORTALIZA", "GRAMINEA", "FLOR", "HIERBA_AROMATICA", "HORTALIZA", "GRAMINEA", "FLOR", "PERENNE", "ARBUSTO", "SUCULENTA", "PERENNE", "HIERBA_AROMATICA", "PERENNE", "HORTALIZA"};
        String array2[] = {"PERENNE", "HORTALIZA", "FLOR", "GRAMINEA", "BULBO", "FLOR", "HIERBA_AROMATICA", "ARBUSTO", "PERENNE", "PERENNE", "HORTALIZA", "HORTALIZA", "SUCULENTA", "BULBO", "BULBO", "FLOR", "ARBUSTO", "HIERBA_AROMATICA", "ARBOL", "PERENNE"};
        
        String array1_1[] = {"PERENNE", "HORTALIZA", "ARBOL", "GRAMINEA", "FLOR", "SUCULENTA", "BULBO", "BULBO", "HIERBA_AROMATICA", "ARBOL", "BULBO", "SUCULENTA", "SUCULENTA", "FLOR", "ARBOL", "SUCULENTA", "SUCULENTA", "PERENNE", "PERENNE", "GRAMINEA"};
        String array2_2[] = {"GRAMINEA", "FLOR", "FLOR", "ARBUSTO", "PERENNE", "ARBUSTO", "BULBO", "BULBO", "ARBOL", "PERENNE", "BULBO", "HIERBA_AROMATICA", "SUCULENTA", "HIERBA_AROMATICA", "BULBO", "HIERBA_AROMATICA", "GRAMINEA", "GRAMINEA", "ARBUSTO", "GRAMINEA"};
        
        String array1_3[] = {"PERENNE", "SUCULENTA", "HORTALIZA", "HORTALIZA", "GRAMINEA", "ARBOL", "FLOR", "FLOR", "GRAMINEA", "PERENNE", "HORTALIZA", "HIERBA_AROMATICA", "ARBOL", "HORTALIZA", "HORTALIZA", "HORTALIZA", "FLOR", "BULBO", "BULBO", "BULBO"};
        String array2_3[] =  {"FLOR", "PERENNE", "ARBOL", "PERENNE", "ARBOL", "GRAMINEA", "GRAMINEA", "HORTALIZA", "HIERBA_AROMATICA", "HORTALIZA", "ARBOL", "ARBOL", "BULBO", "GRAMINEA", "SUCULENTA", "GRAMINEA", "GRAMINEA", "SUCULENTA", "FLOR", "SUCULENTA"};
         */
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        //Rellenamos las listas con valores aleatorios.
        for (int n = 0; n < NUM_PLANTAS; n++) {
            lista1.add(Utilidades.especiePlantaAleatoria());
            lista2.add(Utilidades.especiePlantaAleatoria());
        }

        Iterator<String> itLista1 = lista1.listIterator();
        Iterator<String> itLista2 = lista2.listIterator();
        int pos = 0;
        while (itLista1.hasNext()) {

            String planta = itLista1.next();
            //Detectamos coincidencia entre ambas listas.
            if (planta.equals(itLista2.next())) {
                boolean existe = false;
                //Comprobamos si el nombre de la planta existe en el diccionario como clave.

                for (String key : diccionarioPlantas.keySet()) {
                    if (key.equals(planta)) {
                        existe = true;
                    }
                }//Final for.
                //Si no existe el nombre de la planta como clave, lo añadimos y le asignamos una lista de enteros.
                if (!existe) {
                    diccionarioPlantas.put(planta, new LinkedList<>());
                    existe = true;
                }
                if (existe) {
                    for (Map.Entry<String, List<Integer>> parejas : diccionarioPlantas.entrySet()) {
                        if (parejas.getKey().equals(planta)) {
                            parejas.getValue().add(pos);
                        }
                    }
                }
            }//Final if
            pos++;
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.printf("Contenido inicial de la lista especies de plantas 1: %n%s%n", lista1);
        System.out.printf("Contenido inicial de la lista especies de plantas 2: %n%s%n", lista2);
        System.out.printf("Clasificación de coincidencias %n%s%n", diccionarioPlantas);

    }
}
