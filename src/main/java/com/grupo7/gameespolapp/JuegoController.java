/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.IngresarmatController.materias;
import static com.grupo7.gameespolapp.NuevojuegoController.apoyo0;
import static com.grupo7.gameespolapp.NuevojuegoController.preguntas3;
import com.grupo7.gameespolapp.hilos.CambiaGrid;
import com.grupo7.gameespolapp.hilos.Cronometro;
import static com.grupo7.gameespolapp.hilos.Cronometro.detener;
import com.grupo7.gameespolapp.hilos.MuestraPregunta;
import configuraciones.Pregunta;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import nuevo_juego.ComodinEnJuego;
import static utileria.TipoComodin.COMODIN50_50;
import static utileria.TipoComodin.CONSULTA_COMPAÑERO;
import static utileria.TipoComodin.CONSULTA_SALON;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class JuegoController implements Initializable {
    
    @FXML
    Label pregunta;
    
    @FXML
    Label tiempo;
    
    @FXML
    Label op1;
    
    @FXML
    Label op2;
    
    @FXML
    Label op3;
    
    @FXML
    Label op4;
    
    @FXML
    FlowPane numpreg;
    
    @FXML
    ImageView mitad;
    
    @FXML
    ImageView apoyo;
    
    @FXML 
    ImageView clase;
    
    @FXML
    VBox item;
    
    public static boolean slt =false;
    
    static ArrayList<ComodinEnJuego> comodines=new ArrayList<ComodinEnJuego>();
    
    ComodinEnJuego cej=new ComodinEnJuego(COMODIN50_50,false);
    ComodinEnJuego cej2=new ComodinEnJuego(CONSULTA_COMPAÑERO,false);
    ComodinEnJuego cej3=new ComodinEnJuego(CONSULTA_SALON,false);
    static Thread hiloCuenta; 
    static Thread cambiaPregThread;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hiloCuenta = new Thread(new MuestraPregunta(numpreg));
        //hiloCuenta.setDaemon(true);
        hiloCuenta.start();
        try {
            hiloCuenta.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        cambiaPregThread = new Thread(new CambiaGrid(pregunta,op1,op2,op3,op4, tiempo, slt));
        //cambiaGridThread.setDaemon(true);
        cambiaPregThread.start();


    } 

    /**
     * funcion del comodin 50-50
     */
    @FXML
    private void comodin1(){
        if(cej.isUsado()==false){
            String enun = pregunta.getText();
            ArrayList<String> respuestas = new ArrayList<String>();
            String resp1 = op1.getText();
            String resp2 = op2.getText();
            String resp3 = op3.getText();
            String resp4 = op4.getText();
            
            respuestas.add(resp1);
            respuestas.add(resp2);
            respuestas.add(resp3);
            respuestas.add(resp4);
            
            for(Pregunta p : preguntas3){
                String enun_prin = p.getEnunciado();
                if(enun.equals(enun_prin)){
                    String rspt_Correcta = p.getRepuesta_correcta();
                    int contador=0;
                    for(String s : respuestas){
                        if(!(s.equals(rspt_Correcta))){
                            if(resp1.equals(s) && contador<2){
                                op1.setText(" ");
                                contador++;
                            }else if(resp2.equals(s) && contador<2){
                                op2.setText(" ");
                                contador++;
                            }else if(resp3.equals(s) && contador<2){
                                op3.setText(" ");
                                contador++;
                            }else if(resp4.equals(s) && contador<2){
                                op4.setText(" ");
                                contador++;
                            }
                        }
                    }
                }
                
            }
            
            cej.setUsado(true);
            
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
            alert.setHeaderText("Este comodin ya ha sido usado");
            alert.setContentText("¿Continuar?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

            } else {

            }
            
        }
    }
    
    /**
     * funcion del comodin consulta a un compañero
     */
    @FXML
    private void comodin2(){
        if(cej2.isUsado()==false){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
            alert.setHeaderText("Pregunta a tu compañero "+ apoyo0.getNombre());
            alert.setContentText("¿Continuar?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                cej2.setUsado(true);
            } else {

            }
            
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
            alert.setHeaderText("Este comodin ya ha sido usado");
            alert.setContentText("¿Continuar?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

            } else {

            }
            
        }
        
    }
    
    /**
     * funcion del comodin consulta a la clase
     */
    @FXML
    private void comodin3(){
        if(cej3.isUsado()==false){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
            alert.setHeaderText("Pregunta a la clase");
            alert.setContentText("¿Continuar?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                cej3.setUsado(true);
            } else {

            }
            
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
            alert.setHeaderText("Este comodin ya ha sido usado");
            alert.setContentText("¿Continuar?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

            } else {

            }
            
        }
        
    }
    
    /**
     * funcion de si selecciona la opcion a
     * @throws IOException
     * @throws InterruptedException 
     */
    @FXML
    private void responderOpc1() throws IOException, InterruptedException{
        String enun = pregunta.getText();
        String resp1 = op1.getText();
        
        slt=true;
        for(Pregunta p : preguntas3){
            String enun_prin = p.getEnunciado();
            if(enun.equals(enun_prin)){
                String rspt_Correcta = p.getRepuesta_correcta();
                if(resp1.equals(rspt_Correcta)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la A");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION);
                        alert0.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                        alert0.setHeaderText("Su respuesta es correcta");
                        alert0.setContentText("¿Continuar?");
                        Optional<ButtonType> result1 = alert0.showAndWait();
                        if (result1.get() == ButtonType.OK) {
                            
                        }else{
                            
                        }

                    } else {

                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la A");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        //hiloCuenta.setIsTerminating(true); // tell the thread to stop
                        hiloCuenta.stop(); 
                        cambiaPregThread.stop(); 
                        App.setRoot("gracia");
                    } else {

                    }
                    
                }
            }
            
        }
    }
    
    /**
     * funcion al seleccionar la opcion b
     * @throws IOException
     * @throws InterruptedException 
     */
    @FXML
    private void responderOpc2() throws IOException, InterruptedException{
        String enun = pregunta.getText();
        String resp1 = op2.getText();
        slt=true;
        for(Pregunta p : preguntas3){
            String enun_prin = p.getEnunciado();
            if(enun.equals(enun_prin)){
                String rspt_Correcta = p.getRepuesta_correcta();
                if(resp1.equals(rspt_Correcta)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la B");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION);
                        alert0.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                        alert0.setHeaderText("Su respuesta es correcta");
                        alert0.setContentText("¿Continuar?");
                        Optional<ButtonType> result1 = alert0.showAndWait();
                        if (result1.get() == ButtonType.OK) {
                            
                        }else{
                            
                        }
                    } else {

                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la B");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        hiloCuenta.stop(); 
                        cambiaPregThread.stop(); 
                        App.setRoot("gracia");
                    } else {

                    }
                }
            
            
        }}
    }
    
    /**
     * funcion al seleccionar la opcion c
     * @throws IOException
     * @throws InterruptedException 
     */
    @FXML
    private void responderOpc3() throws IOException, InterruptedException{
        String enun = pregunta.getText();
        String resp1 = op3.getText();
        slt=true;
        for(Pregunta p : preguntas3){
            String enun_prin = p.getEnunciado();
            if(enun.equals(enun_prin)){
                String rspt_Correcta = p.getRepuesta_correcta();
                if(resp1.equals(rspt_Correcta)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la C");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION);
                        alert0.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                        alert0.setHeaderText("Su respuesta es correcta");
                        alert0.setContentText("¿Continuar?");
                        Optional<ButtonType> result1 = alert0.showAndWait();
                        if (result1.get() == ButtonType.OK) {
                            
                        }else{
                            
                        }
                    } else {

                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la C");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        hiloCuenta.stop(); 
                        cambiaPregThread.stop(); 
                        App.setRoot("gracia");
                    } else {

                    }


                    }
            }
            
        }
    }
    
    /**
     * funcion al seleccionar la opcion d
     * @throws IOException
     * @throws InterruptedException 
     */
    @FXML
    private void responderOpc4() throws IOException, InterruptedException{
        String enun = pregunta.getText();
        String resp1 = op4.getText();
        slt=true;
        for(Pregunta p : preguntas3){
            String enun_prin = p.getEnunciado();
            if(enun.equals(enun_prin)){
                String rspt_Correcta = p.getRepuesta_correcta();
                if(resp1.equals(rspt_Correcta)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la D");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION);
                        alert0.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                        alert0.setHeaderText("Su respuesta es correcta");
                        alert0.setContentText("¿Continuar?");
                        Optional<ButtonType> result1 = alert0.showAndWait();
                        if (result1.get() == ButtonType.OK) {
                            
                        }else{
                            
                        }
                    } else {

                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("¿QUIÉN QUIERE SER MILLONARIO?");
                    alert.setHeaderText("La respuesta escogida es la D");
                    alert.setContentText("¿Última palabra?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        hiloCuenta.stop(); 
                        cambiaPregThread.stop(); 
                        App.setRoot("gracia");
                    } else {

                    }

                    }
            }
            
        }
    }


    
}
