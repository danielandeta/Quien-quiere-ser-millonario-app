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
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    /**
     * cambia de ventana a menu configuraciones
     * @throws IOException 
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("configuraciones");
    }
    
    /**
     * cambia ventana a nuevo juego 
     * @throws IOException 
     */
    @FXML
    private void switchNuevojuego() throws IOException{
        App.setRoot("nuevojuego");
    }
    
    /**
     * cambia de ventana a reporte
     * @throws IOException 
     */
    @FXML
    private void switchReporte() throws IOException{
        App.setRoot("reporte");
    }
    
    /**
     * se sale del programa
     */
    @FXML
    private void salir(){

        System.exit(0);
    }
    
}
