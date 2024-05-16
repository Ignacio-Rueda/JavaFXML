/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlbase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author jjber
 */
public class PrincipalController implements Initializable {

    // La referencia al programa principal se tiene en esta variable de tipo
    // Principal. La declaramos privado para que solo se pueda acceder desde 
    // este controlador. 
    private ComunicaVentanas ProgramaPrincipal;

    // Un elemento clave a destacar en JavaFX es la notación @FXML, que sirve
    // para indicar al código que el elemento tiene referencia en el 
    // archivo FXML de la vista (Principal.fxml).
    @FXML
    private void nuevaVentana(ActionEvent event) {
        // Aquí pondremos la llamada para cargar la ventana de alta
    }

    public void setProgramaPrincipal(ComunicaVentanas ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
