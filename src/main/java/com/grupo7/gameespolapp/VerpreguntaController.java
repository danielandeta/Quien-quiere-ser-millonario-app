/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.IngresarmatController.materias;
import configuraciones.Materia;
import configuraciones.Pregunta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class VerpreguntaController implements Initializable {
    ArrayList<Pregunta> preguntas1= new ArrayList<Pregunta>();
    @FXML
    ListView lvMaterias;
    
    @FXML
    ListView lvPreguntas;
    
    Materia ma;
    
    String cod;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvMaterias.getItems().setAll(materias);
    }    
    
    /**
     * cambia de ventana a configuraciones
     * @throws IOException 
     */
    @FXML
    private void switchConf() throws IOException {
        App.setRoot("configuraciones");
    }
    
    /**
     * selecciona materia y lee las preguntas
     * @throws IOException 
     */
    @FXML
    private void seleccionPar() throws IOException {
        Materia m= (Materia)lvMaterias.getSelectionModel().getSelectedItem();
        ma=m;
        cod= m.getCodigo();
        leerPreguntas();

        lvPreguntas.getItems().setAll(preguntas1);
    }
    
    /**
     * lee las preguntas segun el codigo de la materia
     * @throws IOException 
     */
    private void leerPreguntas() throws IOException{
        BufferedReader csvReader = null;
        try {
            
            String rute = cod+".csv";

            String ruta = "src/main/java/archivos/"+rute; //ruta del archivo que se va a leer
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila = csvReader.readLine();//escapar cabecera de archivo
            
            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                
                String[] data = fila.split(";");
                preguntas1.add(new Pregunta(ma,data[0], data[1], data[2], data[3],data[4],data[5])); //crear objeto y agregar a lista

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado"+ex);
        } catch (IOException ex) {
            System.out.println("Error"+ex);
        } finally {
            try {
                csvReader.close();
            } catch (IOException ex) {
                System.out.println("Error"+ex);
            }
        }
    }
    
}
