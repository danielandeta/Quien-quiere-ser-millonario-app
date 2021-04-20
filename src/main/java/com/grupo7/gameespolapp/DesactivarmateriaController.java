/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.IngresarmatController.materias;
import configuraciones.Materia;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class DesactivarmateriaController implements Initializable {

    @FXML
    ListView lvMaterias;
    public String cod_des;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvMaterias.getItems().setAll(materias);

    }
    
    /**
     * cambia de ventana a menu materia
     * @throws IOException 
     */
    @FXML
    private void switchMateria() throws IOException {
        App.setRoot("materia");
    }
    
    /**
     * cambia de ventana a confirmacion de guardar cambios realizados
     * @throws IOException 
     */
    @FXML
    private void switchSeguro() throws IOException {
        //App.setRoot("segurocambio");
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cambios a realizar");
        alert.setHeaderText("Alerta de confirmación");
        alert.setContentText("¿Estás seguro de realizar cambios?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            desactivarMateria();
            lvMaterias.getItems().setAll(materias);
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    /**
     * selecciona materia del list view 
     * @throws IOException 
     */
    @FXML
    public void seleccionMateria() throws IOException {
        Materia m = (Materia) lvMaterias.getSelectionModel().getSelectedItem();
        cod_des = m.getCodigo();
    }

    /**
     * desactiva materia pasa de true a false
     * @throws IOException 
     */
    public void desactivarMateria() throws IOException {
        
        for (Materia m : materias) {
            if (cod_des.equals(m.getCodigo())) {
                m.setActivo(false);

            }
        }

    }
}
