/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlbase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Profesor
 */
public class ComunicaVentanas extends Application {
    
    private Stage stagePrincipal;
        
    // Nombre de la ventana de la vista
    private final String VENTANA_PRINCIPAL = "Principal.fxml" ;
    private final String VENTANA_ALTA = "AltaPersona.fxml" ;
    
    
    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();

    }

    
    /**
     * Cargar la ventana principal. Tenemos acceso al controlador de la vista.
     * Así podemos enviar parámetros a los métodos que definiremos en el
     * controlador. En este caso será el método setProgramaPrincipal(), 
     * con este método creamos la comunicación entre el controlador y el
     * programa principal.
     */
    private void mostrarVentanaPrincipal() {
        AnchorPane panelRaiz ;
        try {
            // Recoger el grafo resultante.
            FXMLLoader loader = new FXMLLoader(ComunicaVentanas.class.getResource(VENTANA_PRINCIPAL));
            // Carga la jerarquía de objetos desde un documento FXML.
            panelRaiz = (AnchorPane) loader.load() ;
            
            // Añadir el panel a la escena
            Scene scene = new Scene(panelRaiz) ;
            // Establecer el título del escenario
            stagePrincipal.setTitle("Ventana Principal") ;
            // Añadir la escena al escenario
            stagePrincipal.setScene(scene) ;
            
            // Obtener el controlador asociado
            PrincipalController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            // Mostrar ventana
            stagePrincipal.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
