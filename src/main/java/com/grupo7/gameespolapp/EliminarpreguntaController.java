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
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
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
public class EliminarpreguntaController implements Initializable {
    ArrayList<Pregunta> preguntas1= new ArrayList<Pregunta>();
    @FXML
    ListView lvMaterias;
    
    @FXML
    ListView lvPreguntas;
    
    Materia ma;
    
    String cod;
    Pregunta pr;
    String enun;

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
     * selecciona un paralelo del list view
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
     * selecciona una pregunta del list view
     * @throws IOException 
     */
    @FXML
    private void seleccionarpreg() throws IOException{
        Pregunta p=(Pregunta)lvPreguntas.getSelectionModel().getSelectedItem();
        pr=p;
        enun= p.getEnunciado();
        
        
    }
    
    /**
     * elimina la pregunta del list view y del archivo que se lee
     * @throws IOException 
     */
    @FXML
    private void eliminarPreg()throws IOException{
        preguntas1.remove(pr);
        System.out.println("P eliminar ******** "+pr);
        //BufferedReader csvReader = null;
        BufferedWriter csvWriter=null;
        //ArrayList<Pregunta> nuevasP = new ArrayList<Pregunta>();
        
        FileWriter writer = null;
        try {
            
            String rute = cod+".csv";

            String ruta = "src/main/java/archivos/"+rute;

            writer = new FileWriter(ruta);
            writer.write("enunciado, nivel, correcta, incorrecta1, incorrecta2, incorrecta3"+System.lineSeparator());
            for (Pregunta est : preguntas1) {
                writer.write(est.getEnunciado()+ ";" + est.getNivel()+ ";" + est.getRepuesta_correcta()+";"+ est.getRepuesta_correcta()+";"+est.getPosible_respuesta1()+";"+est.getPosible_respuesta2()+";"+est.getPosible_respuesta3()+System.lineSeparator());
            }
            writer.close();
        } catch (IOException ex) {
            //Logger.getLogger(BancoPregunta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error" +ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                //Logger.getLogger(BancoPregunta.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error x"+ex);
            }
        }


        lvPreguntas.getItems().setAll(preguntas1);
        
    }
    
    /**
     * lee las preguntas del archivo con nombre del codigo de la materia
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
