package com.grupo7.gameespolapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class TerminoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * cambia de ventana a menu de configuraciones
     * @throws IOException 
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("configuraciones");
    }
    
    /**
     * cambia de ventana para ingresar termino
     * @throws IOException 
     */
    @FXML
    private void switchEditarTermino() throws IOException {
        App.setRoot("editartermino");
    }
    
    /**
     * cambia de ventana para editar termino
     * @throws IOException 
     */
    @FXML
    private void switchEditar1() throws IOException{
        App.setRoot("ediciontermino");
    }
    
    /**
     * cambia de ventana a configurar termino
     * @throws IOException 
     */
    @FXML
    private void switchconfgterm() throws IOException {
        App.setRoot("configtermino");
    }
    
}