package tarea07;

import java.util.Map;
import java.util.TreeMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Ejercicio 3. Calendario de especies de plantas
 *
 * @author Ignacio Rueda Delgado
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int DIAS = 7;//Reprenta el número de días que contiene una jornada semanal.

        // Variables de entrada
        // Variables auxiliares
        String planta; //Almacenar planta que obtenemos de utilidades, para después comprobar si existe o no.
        Map<LocalDate, String> calendario = new TreeMap<>();
        LocalDate fechaActual = LocalDate.now().minusDays(1);//Obtenemos la fecha actual y restamos un día, ya que en el bucle, iremos incrementando la fecha.
        int posDia = 1;//Variable para acumular el número de días incrementados.
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");//Definimos formato fecha.
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CALENDARIO DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        while (calendario.size() < DIAS) {
            planta = Utilidades.especiePlantaAleatoria();
            if (!calendario.containsValue(planta)) {//Si no existe, insertamos.
                calendario.put(fechaActual.plusDays(posDia), planta);
                posDia++;
            }
        }

        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.printf("Contenido final del mapa de especies de plantas organizado por fechas:%n");
        for (Map.Entry<LocalDate, String> pareja : calendario.entrySet()) {
            System.out.printf("Fecha %s: %s%n", pareja.getKey().format(formatoFecha), pareja.getValue());
        }

    }
}
