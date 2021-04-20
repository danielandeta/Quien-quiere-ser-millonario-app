/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.GraciaController.reportes;
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
public class ReporteController implements Initializable {
    @FXML
    ListView lvreportes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvreportes.getItems().setAll(reportes);
    }    
    
    /**
     * cambia de ventana al menu principal
     * @throws IOException 
     */
    @FXML
    private void switchMenu() throws IOException{
        App.setRoot("principal");
    }
    
}
