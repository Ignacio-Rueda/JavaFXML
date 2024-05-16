package ejercicio3;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Clase que permite serializar un objeto Recetario al formato XML y viceversa.
 *
 * @author profe
 */
public class RecetarioXML {

    // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo = System.getProperty("user.dir") + "/recursos/Recetario.xml";

    // Objeto Xstream que permite la L/E con archivos XML
    private XStream xstream;

    /**
     * Método constructor
     *
     * @param nombreArchivo Ruta del archivo donde se lee y escribe el objeto
     * Recetario
     */
    public RecetarioXML(String nombreArchivo) {
        this.rutaArchivo = nombreArchivo;
        this.xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        this.xstream.allowTypesByWildcard(new String[]{
            "ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    // -----------------------------------------------------
    // Ejercicio 3: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    // 3.1. Método escribir()
    /**
     * Método que escribe, en un archivo de texto, un objeto Recetario
     * serializable.
     *
     * @param recetario Objeto Recetario serializable para almacenar en el
     * archivo de texto.
     */
    public void escribir(Recetario recetario) {
        // Incluir el código que debe realizar el método
        String xml = xstream.toXML(recetario);

        try (PrintWriter pr = new PrintWriter(new FileWriter(rutaArchivo))) {
            pr.write(xml);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    // 3.2. Método leer()
    /**
     * Método que lee, desde un archivo de texto, un objeto Recetario
     * serializado.
     *
     * @return Objecto Recetario que estaba almacenado en el archivo de texto.
     */
    public Recetario leer() {
		String xml = "";
		String cadena = "";

		Recetario recetario = null;
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
             
			xml = br.readLine();
			while ((cadena = br.readLine()) != null) {
				xml = xml + "\n" + cadena;
			}
                        	
			recetario = (Recetario) xstream.fromXML(xml); // deserialize from XML

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
        return recetario; 
    }
}
