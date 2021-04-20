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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class EdicionterminoController implements Initializable {
    
    @FXML
    ListView lvTerminos;
    @FXML
    TextField anionuevo;
    @FXML
    TextField num_nuevo;
    static TerminoAcademico t;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvTerminos.getItems().setAll(terminos);
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
     * cambia de ventana a ventana de existente
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
     * guardar un nuevo termino al array de terminos
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    @FXML
    private void seleccionar(){
        TerminoAcademico term = (TerminoAcademico) lvTerminos.getSelectionModel().getSelectedItem();
        t=term;
        String anio= term.getAnio();
        String num= term.getNumero();
        anionuevo.setText(anio);
        num_nuevo.setText(num);
        
    }
    @FXML
    private void guardarTermino() throws FileNotFoundException, IOException {
        /*TerminoAcademico t = (TerminoAcademico) lvTerminos.getSelectionModel().getSelectedItem();
        String anio= t.getAnio();
        String num= t.getNumero();
        anionuevo.setText(anio);
        num_nuevo.setText(num);*/
        //TerminoAcademico ter= new TerminoAcademico(anionuevo.getText(),num_nuevo.getText());
        int cont=0;
        for(TerminoAcademico term:terminos){
            if(((t.getAnio()).equals(term.getAnio()))&&((t.getNumero()).equals(term.getNumero()))){
                cont+=1;
                
            }else if(((anionuevo.getText()).equals(term.getAnio())) && ((num_nuevo.getText()).equals(term.getNumero()))){
                cont+=2;
                
            }
        }
        if(cont<2){
            t.setAnio(anionuevo.getText());
            t.setNumero(num_nuevo.getText());
            switchGuardado();
        }else{
            switchExistente();
        }
    }
    
    
    
}
