/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.AgregarparaleloController.paralelos;
import configuraciones.Paralelo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class EliminarparaleloController implements Initializable {
    @FXML
    ListView lvParalelos;
    
    Paralelo par;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvParalelos.getItems().setAll(paralelos);
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
     * selecciona un paralelo del list view
     * @throws IOException 
     */
    @FXML
    private void seleccionarParalelo()throws IOException{
        //Paralelo par=new Paralelo();
        par= (Paralelo) lvParalelos.getSelectionModel().getSelectedItem();

    }
    
    /**
     * elimina un paralelo del list view
     * @throws IOException 
     */
    @FXML
    private void eliminarParalelo() throws IOException{
        paralelos.remove(par);
        lvParalelos.getItems().setAll(paralelos);
    }
    
}
