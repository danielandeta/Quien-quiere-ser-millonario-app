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
public class MateriaController implements Initializable {

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
     * cambia de ventana para ingresar materia
     * @throws IOException 
     */
    @FXML
    private void switchIngresarMat() throws IOException {
        App.setRoot("ingresarmat");
    }
    
    /**
     * cambia de ventana para editar una materia
     * @throws IOException 
     */
    @FXML
    private void switchEditarMat() throws IOException {
        App.setRoot("editarmateria");
    }
    
    /**
     * cambia de ventana para desactivar una materia
     * @throws IOException 
     */
    @FXML
    private void switchDesactivarMat() throws IOException {
        App.setRoot("desactivarmateria");
    }
    
    /**
     * cambia de ventana para agregar paralelo
     * @throws IOException 
     */
    @FXML
    private void switchIngParalelo() throws IOException {
        App.setRoot("agregarparalelo");
    }
    
    /**
     * cambia de materia para eliminar paralelo
     * @throws IOException 
     */
    @FXML
    private void switchEliminarParalelo() throws IOException {
        App.setRoot("eliminarparalelo");
    }
}
