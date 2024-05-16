package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1: Lectura/escritura de un recetario en ficheros de texto.
 *
 * @author profe
 */
public class Ejercicio1 {

    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables de salida
        // Variables auxiliares
        List<String> listadoIngredientes = new ArrayList<>();
        String[] arrayCadena;
        String[] arrayTotalRecetas;
        Receta receta = null;
        String nombre = ""; //Almacena el nombre del plato.
        String tipoPlato = "";//Almacena el tipo de plato.
        LocalDate fechaCreacion; //Almacena fecha creación.
        String[] listadoIngredientesSplit; //Array que almacena el listado de ingredientes.
        String[] instruccionesArray; //Array para almacenar las instrucciones 
        String instrucciones = ""; //Cadena con las instrucciones (Solo para el apartado en el que leemos)

        StringBuilder linea = new StringBuilder();

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // Abrimos archivo de contactos ListadoRecetas.txt
        System.out.println("Abriendo archivo de recetas...");
        String rutaRecetas = System.getProperty("user.dir") + "/recursos/ListadoRecetas.txt";
        String rutaRecetario = System.getProperty("user.dir") + "/recursos/Recetario.txt";
        Recetario recetario = new Recetario();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaRecetas))) {
            String cadena = "";
            while (cadena != null) {
                cadena = br.readLine();
                if (cadena != null) {
                    arrayCadena = cadena.split(";");
                    //Se extraen los datos de cada una de las recetas: nombre, tipo de plato, fecha de creación, listado de ingredientes e instrucciones.
                    nombre = arrayCadena[0];
                    tipoPlato = arrayCadena[1];
                    fechaCreacion = LocalDate.parse(arrayCadena[2]);
                    listadoIngredientesSplit = arrayCadena[3].split("\\,");
                    instrucciones = arrayCadena[4];
                    //Se extraen los ingredientes de manera individual y se insertan en una lista. Cada ingrediente se separa por el carácter ",".
                    for (int n = 0; n < listadoIngredientesSplit.length; n++) {
                        listadoIngredientes.add(listadoIngredientesSplit[n]);
                    }
                    //Para cada receta generamos un objeto de tipo Receta con los datos extraídos en los puntos anteriores.
                    receta = new Receta(nombre, tipoPlato, fechaCreacion, listadoIngredientes, instrucciones);
                    listadoIngredientes.clear();
                }//Bucle if
                if (cadena != null) {
                    recetario.add(receta);
                }

            }//Fin while

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Cerrando archivo de recetas...");
        System.out.println();

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        // Abrimos el archivo de la agenda Recetario.txt
        System.out.println("Abriendo archivo del recetario...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaRecetario))) {
            //1. Obtenemos las recetas separadas con el método split.
            arrayTotalRecetas = recetario.toString().split("\n");
            linea.append("**********************************************************************************************************************************\n"
                    + "LIBRO DE RECETAS\n"
                    + "*********************************************************************************************************************************\n");
            //2. En cada iteración tenemos una receta (Al haber hecho un split de recetario.toString)
            for (int n = 0; n < arrayTotalRecetas.length; n++) {
                //3.  Obtenemos cada una de las partes de una receta (nombre,tipoPlato,fechaCreación etc)
                arrayCadena = arrayTotalRecetas[n].split(";");
                //4. En lugar de utilizar las variables, nombre,tipoPlato... implementamos arrayCadena[posicionDeseada] en la "línea" a escribir.
                //5. Instrucciones tiene un formato diferente (Número, punto, guión etc) de manera que tenemos que almacenarlo en un array para posteriormente aplicar el formato.
                instruccionesArray = arrayCadena[4].split("\\.");

                String instruccionesEnumeradas = "";//En cada iteración borramos las instrucciones, para que la cadena esté vacía.
                for (int i = 0; i < instruccionesArray.length; i++) {
                    instruccionesEnumeradas += String.format("%d.- %s.%n",
                            i + 1,
                            instruccionesArray[i]);
                }
                //6. Añadimos la línea al StringBuilder
                linea.append(String.format("NOMBRE DE LA RECETA:%s%nTIPO DE PLATO:%s%nFECHA DE CREACIÓN:%s%nINGREDIENTES:%s%nINSTRUCCIONES: %n%s",
                        arrayCadena[0].substring(1),
                        arrayCadena[1],
                        LocalDate.parse(arrayCadena[2]),
                        arrayCadena[3],
                        instruccionesEnumeradas
                ));
                linea.append("*********************************************************************************************************************************\n");
            }
            pw.write(linea.toString());
            pw.flush();;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Cerrando archivo del recetario...");

        System.out.println();
        System.out.println("Archivos cerrados y procesamiento finalizado");
        System.out.println("---------");
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
