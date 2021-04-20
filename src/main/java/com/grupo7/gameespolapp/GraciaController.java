/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.JuegoController.cambiaPregThread;
import static com.grupo7.gameespolapp.JuegoController.hiloCuenta;
import static com.grupo7.gameespolapp.NuevojuegoController.numerador;
import static com.grupo7.gameespolapp.NuevojuegoController.participante;
import static com.grupo7.gameespolapp.hilos.CambiaGrid.contador;
import static com.grupo7.gameespolapp.hilos.CambiaGrid.cronometro;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import nuevo_juego.Juego;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GraciaController implements Initializable {
    
    @FXML
    TextField premio;
    
    String fecha_juego;
    public static ArrayList<Juego> reportes= new ArrayList<Juego>();
    
    //Juego j1 = new Juego("Fecha   - ","Participante          - ","Nivel  - ","Premio   ");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //reportes.add(j1);
    }  
    
    /**
     * cierra los hilos y cambia de ventana al menu principal
     * @throws IOException 
     */
    @FXML
    private void salir() throws IOException{
        
        cambiaPregThread.stop();
        hiloCuenta.stop();
        cronometro.stop();
        
        App.setRoot("principal");
    }
    
    /**
     * guarda reporte
     * @throws IOException 
     */
    @FXML
    private void guardarRep() throws IOException{
        salir();
        int nivel= (contador-1)/numerador;
        Calendar fecha= Calendar.getInstance();
        int anio= fecha.get(Calendar.YEAR);
        int mes=fecha.get(Calendar.MONTH)+1;
        int dia= fecha.get(Calendar.DATE);
        fecha_juego=String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(anio);
        //System.out.println(fecha_juego);
        //System.out.println(nivel);
        String premio_juego= premio.getText();
        Juego j= new Juego(fecha_juego,participante.getNombre(),String.valueOf(nivel),premio_juego);
        reportes.add(j);
        
        
    }
    /**
     * cambia de ventana a menu principal
     * @throws IOException 
     */
    @FXML
    private void switchMenu() throws IOException{
        App.setRoot("principal");
    }
    
}
