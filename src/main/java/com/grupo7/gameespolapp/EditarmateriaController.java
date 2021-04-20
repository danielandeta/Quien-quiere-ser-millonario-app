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
public class EditarmateriaController implements Initializable {
    
    @FXML
    ListView lvMaterias;
    @FXML
    TextField codnuevo;
    @FXML
    TextField nom_nuevo;
    @FXML
    TextField niv_nuevo;
    Materia m;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvMaterias.getItems().setAll(materias);
        // TODO
    }    
    
    /**
     * cambia de ventana a ventana de configuraciones
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
     * cambia ventana a ventana de cmabios guardados
     * @throws IOException 
     */
    @FXML
    public static void switchGuardado() throws IOException {
        App.setRoot("guardado");
    }
    
    @FXML
    private void seleccionar(){
        Materia mat = (Materia) lvMaterias.getSelectionModel().getSelectedItem();
        m=mat;
        String cod= mat.getCodigo();
        String nombre= mat.getNombre();
        String nivel= mat.getCantidadNiveles();
        codnuevo.setText(cod);
        nom_nuevo.setText(nombre);
        niv_nuevo.setText(nivel);
    }
    
    /**
     * guarda la materia y la agrega al array de materias
     * @throws IOException 
     */
    @FXML
    private void guardarMateria() throws IOException {
        //Materia m = (Materia) lvMaterias.getSelectionModel().getSelectedItem();
        //TerminoAcademico ter= new TerminoAcademico(anionuevo.getText(),num_nuevo.getText());
        int cont=0;
        for(Materia mat: materias){
            if((m.getCodigo()).equals(mat.getCodigo())){
                cont+=1;
                
            }else if((codnuevo.getText()).equals(mat.getCodigo())){
                cont+=2;
                
            }
        }
        if(cont<2){
            m.setCodigo(codnuevo.getText());
            m.setNombre(nom_nuevo.getText());
            m.setCantidadNiveles(niv_nuevo.getText());
            m.setActivo(true);
            switchGuardado();
        }else{
            switchExistente();
        }
    }
    
}
