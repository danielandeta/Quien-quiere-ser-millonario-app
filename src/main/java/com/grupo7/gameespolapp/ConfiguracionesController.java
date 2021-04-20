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
public class ConfiguracionesController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    /**
     * cambia de ventana al menu principal
     * @throws IOException 
     */
    public void switchToPrimary() throws IOException {
        App.setRoot("principal");
    }
    
    /**
     * cambia de ventana a menu de materia
     * @throws IOException 
     */
    @FXML
    private void switchMateria() throws IOException {
        App.setRoot("materia");
    }
    
    /**
     * cambia de ventana a menu esttudiante
     * @throws IOException 
     */
    @FXML
    private void switchEstudiante() throws IOException {
        App.setRoot("estudiante");
    }
    
    /**
     * cambia de ventana a menu de preguntas
     * @throws IOException 
     */
    @FXML
    private void switchPreguntas() throws IOException {
        App.setRoot("preguntas");
    }
    
    /**
     * cambia de ventana a menu de termino
     * @throws IOException 
     */
    @FXML
     private void switchTerminoAcademico() throws IOException{
         App.setRoot("termino");
     }
     

    
      
    
}
