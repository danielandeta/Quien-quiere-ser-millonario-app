/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PreguntasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
     * cambia de ventana a ver preguntas
     * @throws IOException 
     */
    @FXML
    private void switchvisualizar() throws IOException {
        App.setRoot("verpregunta");
    }
    
    /**
     * cambia de ventana a agregar preguntas
     * 
     * @throws IOException 
     */
    @FXML
    private void switchAgregar() throws IOException {
        App.setRoot("addpregunta");
    }
    
    /**
     * cambia de ventana a eliminar preguntas
     * @throws IOException 
     */
    @FXML
    private void switchEliminar() throws IOException {
        App.setRoot("eliminarpregunta");
    }
    
}
