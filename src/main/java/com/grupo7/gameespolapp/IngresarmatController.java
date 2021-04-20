/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.EditarterminoController.switchExistente;
import static com.grupo7.gameespolapp.EditarterminoController.switchGuardado;
import static com.grupo7.gameespolapp.EditarterminoController.terminos;
import configuraciones.Materia;
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
public class IngresarmatController implements Initializable {
    
    public static ArrayList<Materia> materias= new ArrayList<Materia>();
    
    @FXML
    TextField txtCod;
    
    @FXML
    TextField txtNombre_mat;
    
    @FXML
    TextField txtNumero;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
     * 
     * cambia de materia a existente
     */
    @FXML
    public static void switchExistente() throws IOException {
        App.setRoot("existente");
    }
    
    /**
     * cambia de ventana a cambios guardados
     * @throws IOException 
     */
    @FXML
    public static void switchGuardado() throws IOException {
        App.setRoot("guardado");
    }
    
    /**
     * guarda la materia en el array de materias
     * @throws IOException 
     */
    public void guardarMateria() throws IOException {
        int i=0;
        for(Materia m:materias){

            if (!((m.getCodigo()).equals(txtCod.getText()))){
                i+=0;
                
            }else{
                i+=1;
            }               
        }

        if (i==0){
            Materia mat=new Materia(txtNombre_mat.getText(),txtCod.getText(),txtNumero.getText(),true);
            materias.add(mat);
            switchGuardado();
            
        }else{
            switchExistente();
        }
       
    }
    
}
