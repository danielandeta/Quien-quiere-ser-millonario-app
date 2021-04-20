/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.IngresarmatController.materias;
import configuraciones.Materia;
import configuraciones.Pregunta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AddpreguntaController implements Initializable {
    
    @FXML
    ListView lvMaterias;
    
    @FXML 
    TextField tenunciado;
    
    @FXML 
    TextField tcorrecta;
    
    @FXML 
    TextField tnivel;
    
    @FXML 
    TextField tincorrecta1;
    
    @FXML 
    TextField tincorrecta2;
    
    @FXML 
    TextField tincorrecta3;
    static Materia m0;
    static Pregunta p;

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
     * selecciona una materia
     * @throws IOException 
     */
    @FXML
    private void seleccMat()throws IOException{
        Materia m= (Materia) lvMaterias.getSelectionModel().getSelectedItem();
        m0=m;
    }
    
    /**
     * guarda las preguntas ingresadas en un archivo
     * @throws IOException 
     */
    @FXML
    private void guardar() throws IOException{
        String enun= tenunciado.getText();
        String nivel=tnivel.getText();
        String correcta= tcorrecta.getText();
        String incorr= tincorrecta1.getText();
        String incorr2= tincorrecta2.getText();
        String incorr3= tincorrecta3.getText();
        Pregunta preg=new Pregunta(m0,enun,nivel, correcta, incorr, incorr2,incorr3);
        p=preg;
        escribir();
    }
    
    /**
     * escribe las preguntas ingresadas en un archivo de nombre el codigo de la materia
     */
    public static void escribir() {

        File f;

        f = new File("src/main/java/archivos/"+ m0.getCodigo()+".csv");
        try {
            FileWriter w = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            //wr.write("enunciado,nivel,respuesta_correcta,respuesta_posible1,respuesta_posible2,respuesta_posible3");
            
            wr.println(p.getEnunciado()+ ";" + p.getNivel() + ";" + p.getRepuesta_correcta() + ";" + p.getPosible_respuesta1()+ ";" +p.getPosible_respuesta2() +";" +p.getPosible_respuesta3());
            

            wr.close();
            bw.close();
        } catch (IOException e) {
        }

    }
    
}
