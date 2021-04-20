/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

//import static com.grupo7.gameespolapp.DesactivarmateriaController.desactivarMateria;
import configuraciones.Materia;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class SegurocambioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * cambia de ventana a cambios guardados
     * @throws IOException 
     */
    @FXML
    private void switchGuardado() throws IOException{
        App.setRoot("guardado");
    }
    
    /**
     * cambia de ventana a configuraciones
     * @throws IOException 
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("configuraciones");
    }
    
    /**
     * cambia de ventana a cambios guardados
     * @throws IOException 
     */
    @FXML
    private void guardarCambios() throws IOException {

        switchGuardado();
        
        
    }
    
}
