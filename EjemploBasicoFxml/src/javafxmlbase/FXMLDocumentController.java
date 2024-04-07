/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlbase;

import com.sun.javafx.scene.shape.TextHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author jjber
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField textNombre;
    @FXML
    private TextArea txtArea;

    @FXML
    private void mostrar(ActionEvent event) {
        txtArea.setText(textNombre.getText());
    }
    @FXML
    private void borrar(ActionEvent event){
        txtArea.setText("");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
