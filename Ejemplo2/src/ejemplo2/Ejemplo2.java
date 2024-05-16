/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.h2.tools.Server;
import static java.lang.System.*;
import java.sql.ResultSet;
import java.util.stream.Collectors;
public class Ejemplo2 {
    /**
     * Nombre del archivo de base de datos local.
     */
    private static final String DB_NAME = "contabilidad.h2db";
    /**
     * URL para la conexión a la base de datos.
     */
    private static final String CONNECTION_URL = "jdbc:h2:./" + DB_NAME;
    /**
     * Driver a utilizar para conectarse a la base de datos.
     */
    private static final String DRIVER = "org.h2.Driver";
    /**
     * Opciones de conexión. 
     */
    private static final String CU_PARAMS = ";MODE=MySQL;AUTO_RECONNECT=TRUE";
    
    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB="/resources/estructuradb.sql"; 
    
    public static void main(String[] args) {
     boolean driverCargado=false;
        
        //Carga del driver de la base de datos.
        try {
            Class.forName(DRIVER) ; 
            driverCargado=true;
        } catch (ClassNotFoundException e) {
            err.printf("No se encuentra el driver de la base de datos (%s)\n", DRIVER);
        }
         
        //Si el driver está cargado, aseguramos que podremos conectar.
        if (driverCargado) {
            //Conectamos con la base de datos.
            //El try-with-resources asegura que se cerrará la conexión al salir.
            String[] wsArgs={"-baseDir",System.getProperty("user.dir"),"-browser"};
            try (Connection con = DriverManager.getConnection(CONNECTION_URL+CU_PARAMS,"","")) {
                
                //iniciamos el servidor web interno (consola H2 para depuraciones)
                Server sr=Server.createWebServer(wsArgs);                              
                sr.start();
                System.out.println("Página local"+sr.getURL());
                createTables(con);
                
                bloquearHastaPulsarTecla();
                sr.stop();
                sr.shutdown();
            }catch(SQLException ex){
                System.out.println("No se ha podido conectar");
            }}  
    }
    
    
    private static void bloquearHastaPulsarTecla(){
        try{
            in.read();
        }catch(IOException e){
        }
    }
    
    public static boolean createTables (Connection con){
        boolean ok = false;
        
        try(Statement st = con.createStatement()){
            String sqlScript = loadResourceAsString(ESTRUCTURA_DB);
            if(sqlScript != null){
                st.execute(sqlScript);
                ok = true;
            }
        }catch(SQLException ex){
            System.out.println("Problema cargando archivo");
        }
        
        return ok;
    }
      public static String loadResourceAsString(String resourceName) {
        String resource = null;
        InputStream is = Ejemplo2.class.getResourceAsStream(resourceName);
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is);  BufferedReader br = new BufferedReader(isr);) {
                resource = br.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.err.printf("Problema leyendo el recurso como cadena: %S\n ", resourceName);
            }
        }
        return resource;
    }
}
