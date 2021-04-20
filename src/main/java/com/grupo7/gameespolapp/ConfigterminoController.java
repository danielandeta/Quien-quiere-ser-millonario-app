/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.EditarterminoController.terminos;
import configuraciones.TerminoAcademico;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ConfigterminoController implements Initializable {
    @FXML
    ListView lvTerminos;
    public static String termino_nuevo;
    
    @FXML
    Label actual;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvTerminos.getItems().setAll(terminos);
        if(termino_nuevo!=null){
            actual.setText(termino_nuevo);
        }else{
            actual.setText("No hay termino configurado");
        }
        
        
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
     * cambia a ventana de cambias guardados
     * @throws IOException 
     */
    @FXML
    private void switchGuardado() throws IOException{
        App.setRoot("guardado");
    }
    
    /**
     * selecciona termino del list view
     * 
     * @throws IOException 
     */
    @FXML
    private void usarTermino() throws IOException {
        TerminoAcademico t = (TerminoAcademico) lvTerminos.getSelectionModel().getSelectedItem();
        termino_nuevo= t.getAnio()+"-"+t.getNumero();
        //String act=t.
        actual.setText(termino_nuevo);
    }
    
}
