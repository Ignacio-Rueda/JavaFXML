package ejercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase encargada de realizar la lectura y escritura de objetos Recetario en archivos binarios.
 * @author profe
 */
public class RecetarioIO {
    
    // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo = System.getProperty("user.dir") + "/recursos/Recetario.dat";

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe el objeto Recetario
     */
    public RecetarioIO(String archivo) {
        this.rutaArchivo = archivo;
    }
    
 
    // -----------------------------------------------------
    // Ejercicio 2: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    /**
     * Método que lee, desde un archivo binario, un objeto Recetario serializado.
     * @return Objeto Recetario que estaba almacenado en el archivo binario.
     */
    public Recetario leer() {
        Recetario recetario = null;
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(this.rutaArchivo))){
            recetario = (Recetario) entrada.readObject();
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return recetario; 
    }
    
    /**
     * Método que escribe, en un archivo binario, un objeto Recetario serializable.
     * @param recetario Objeto Recetario serializable para almacenar en el archivo binario.
     */   
    public void escribir(Recetario recetario) {
        // Incluir el código que debe realizar el método
        try(ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(this.rutaArchivo))){
            salida.writeObject(recetario);
            
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
}
