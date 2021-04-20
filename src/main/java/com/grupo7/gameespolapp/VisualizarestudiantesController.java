/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.AgregarparaleloController.paralelos;
import static com.grupo7.gameespolapp.EditarterminoController.terminos;
import static com.grupo7.gameespolapp.IngresarmatController.materias;
import configuraciones.Estudiante;
import configuraciones.Paralelo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class VisualizarestudiantesController implements Initializable {
    
    
    @FXML 
    ListView lvEstud;
    
    @FXML
    ListView lvParalelos;
    
    @FXML
    ListView lvEstudiantes;

    String par;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvParalelos.getItems().setAll(paralelos);
        //lvEstudiantes.getItems().setAll(estudiantes1);
    }    
    
    /**
     * cambia a ventana de configuraciones
     * @throws IOException 
     */
    @FXML
    private void switchConf() throws IOException {
        App.setRoot("configuraciones");
    }
    
    /**
     * selecciona paralelo del listview
     * @throws IOException 
     */
    @FXML
    private void seleccionPar() throws IOException {
        Paralelo p= (Paralelo) lvParalelos.getSelectionModel().getSelectedItem();
        par= p.toString();
        lvEstud.getItems().setAll(p.getEstudiantes());
    }
    
    
}
