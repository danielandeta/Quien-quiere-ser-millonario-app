/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import configuraciones.TerminoAcademico;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class EditarterminoController implements Initializable {
    
    @FXML
    TextField txtAnio;
    @FXML
    TextField txtNumero;
    public static ArrayList<TerminoAcademico> terminos= new ArrayList<TerminoAcademico>();

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    /**
     * cambia de ventana a menu termino
     * @throws IOException 
     */
    @FXML
    private void switchTermino() throws IOException {
        App.setRoot("termino");
    }
    
    /**
     * cambia de ventana a ventana de archivo ya existente
     * @throws IOException 
     */
    @FXML
    public static void switchExistente() throws IOException {
        App.setRoot("existente");
    }
    
    /**
     * cambia de ventana a ventana de cambios guardados
     * @throws IOException 
     */
    @FXML
    public static void switchGuardado() throws IOException {
        App.setRoot("guardado");
    }
    
    
    /**
     * guardar termino y lo agrega al list view
     * @throws IOException 
     */
    public void guardarTermino() throws IOException {

        int cont=0;
        for(TerminoAcademico t:terminos){

            if (!(((t.getAnio()).equals(txtAnio.getText()))&& ((t.getNumero()).equals(txtNumero.getText())))){
                cont+=0;
                
            }else{
                cont+=1;
            }
    
        }

        if (cont==0){
            TerminoAcademico term=new TerminoAcademico(txtAnio.getText(),txtNumero.getText());
            terminos.add(term);
            switchGuardado();
            
        }else{
            switchExistente();
        }
       
    }
    
}
