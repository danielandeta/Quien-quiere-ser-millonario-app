/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp.hilos;

import static com.grupo7.gameespolapp.NuevojuegoController.preguntas3;
import configuraciones.Pregunta;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;

/**
 *
 * @author DELL
 */
public class MuestraPregunta extends Thread {
    
    private Label lbl;
    private GridPane gp;
    private FlowPane fp;
    private VBox vb;
    

    public MuestraPregunta(FlowPane fp) {
        //this.lbl = lbl;
        //this.gp = gp;
        this.fp = fp;
    }


    /**
     * muestra el contenido del vbox
     * @param i
     * @param panelFP 
     */
    private void mostrarFP(int i, VBox panelFP){
         
        Label labelP = new Label("Pregunta # "+i);
        panelFP.getChildren().add(labelP);
        fp.getChildren().add(panelFP);
    }
    
    

    
    /**
     * enumera las preguntas 
     */
    @Override
    public void run() {
        fp.getChildren().clear();
        VBox vb1=new VBox(10);
        fp.getChildren().add(vb1);
        for(int i=0; i<preguntas3.size();i++){
            //slt = false;
            int x=i+1;
            Platform.runLater(() -> {
            
            
                Label lbl0 = new Label("Pregunta # "+x);
                //lbl0.setFont(new Color(getWhite,getWhite,getWhite,getWhite));
                //lbl0.setOpaque(true);
                lbl0.setFont(new Font("Helvetica",  23));
                

                vb1.getChildren().add(lbl0);
            //fp.getChildren().add(vb1);
            });
            siesta();
        }


    }  
    
    /**
     * el hilo de duerme por 15 segundos
     */
    public void siesta(){
       
        try {
            sleep(15000);
        } catch (InterruptedException ex) {
            System.out.println("error en sleep");
        }
        
    }
    
    
}
