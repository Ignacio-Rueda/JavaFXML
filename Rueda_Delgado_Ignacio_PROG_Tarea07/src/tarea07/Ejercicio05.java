package tarea07;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Ejercicio 5. Ordenación de especies de plantas (por nombre y longitud)
 *
 * @author Ignacio Rueda Delgado.
 */
public class Ejercicio05 {

    /**
     * Recibe una lista de tipo String, la recorre y alamacena en una sola
     * cadena con los saltos de línea oportunos.
     *
     * @param listaPlantas
     * @return Una cadena de texto.
     */
    public static String showInfo(List<String> listaPlantas) {
        int contador = 0; //Contador iteraciones
        StringBuilder resultado = new StringBuilder();
        ListIterator<String> it = listaPlantas.listIterator();

        while (it.hasNext()) {
            resultado.append(String.format("%d. %s%n",
                    ++contador,
                    it.next()
            ));
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int NUM_PLANTAS = 5;//Cantidad de plantas a generar.
        // Variables de entrada

        // Variables auxiliares
        List<String> listaPlantas = new LinkedList<>();
        String planta;
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        //PRUEBAS EJERCICIO.
        /*
        listaPlantas.add("BULBO");
        listaPlantas.add("PERENNE");
        listaPlantas.add("ARBUSTO");
        listaPlantas.add("ARBOL");
        listaPlantas.add("HORTALIZA");
         */
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("ORDENACIÓN DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");

        while (listaPlantas.size() < NUM_PLANTAS) {
            planta = Utilidades.especiePlantaAleatoria();
            if (!(listaPlantas.contains(planta))) {//Si no existe la planta la añadimos.
                listaPlantas.add(planta);
            }
        }
        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        System.out.printf("Contenido inicial de la lista: %n");
        System.out.printf("%s%n", Ejercicio05.showInfo(listaPlantas));

        System.out.printf("Ordenación de la lista por nombre (alfabético): %n");
        Collections.sort(listaPlantas, new ComparadorEspeciePlantaPorNombre());//Pasamos la lista que queremos ordenar y un objeto/instancia de la clase que lo realiza.
        System.out.printf("%s%n", Ejercicio05.showInfo(listaPlantas));

        System.out.printf("Ordenación de la lista por longitud: %n");
        Collections.sort(listaPlantas, new ComparadorEspeciePlantaPorLongitud());//Pasamos la lista que queremos ordenar y un objeto/instancia de la clase que lo realiza.
        System.out.printf("%s%n", Ejercicio05.showInfo(listaPlantas));

    }
}

/**
 * La ventaja que tenemos al crear estas clases de ordenación frente a la
 * implementación de Comparable en una clase propiamente dicha es que de este
 * modo, puedes tener varios criterios de ordenación.
 *
 * @author Ignacio
 */
/**
 * Comparación por nombre de la planta.
 *
 * @author Ignacio
 */
class ComparadorEspeciePlantaPorNombre implements Comparator<String> {

    /**
     *
     * @param planta1
     * @param planta2
     * @return Devuelve un entero negativo,mayor a 0 o inferior a 0.
     */
    @Override
    public int compare(String planta1, String planta2) {
        return planta1.compareTo(planta2);//Dado que la clase String ya incorpora un método comparteTo, nos limitamos a usarlo y no creamos una lógica diferente.
    }

}

/**
 * Comparación por longitud de la planta.
 *
 * @author Ignacio
 */
class ComparadorEspeciePlantaPorLongitud implements Comparator<String> {

    @Override
    public int compare(String planta1, String planta2) {
        return Integer.compare(planta1.length(), planta2.length());//La clase Integer, posee un método estático que permite comparar dos enteros.
    }

}
