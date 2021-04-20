/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp.hilos;

import com.grupo7.gameespolapp.App;
import static com.grupo7.gameespolapp.NuevojuegoController.preguntas3;
import static com.grupo7.gameespolapp.hilos.Cronometro.detener;
import configuraciones.Pregunta;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import static com.grupo7.gameespolapp.JuegoController.slt;

/**
 *
 * @author Gladys
 */
public class CambiaGrid extends Thread  {

    private ArrayList<String> respuestas = new ArrayList<>();
    private GridPane grid = new GridPane();//grid pane a actualizar
    private Text text;//donde se encuentra el número con el que realiza la operación
    private Label pregunta;
    private Label lbl1;
    private Label lbl2;
    private Label lbl3;
    private Label lbl4;
    private Label lbl0;
    private boolean slct;
    public static Thread cronometro;
    public static int contador=0;

    public CambiaGrid(Label pregunta, Label lbl1,Label lbl2,Label lbl3,Label lbl4, Label lbl0, boolean slct){
        //this.respuestas =respuestas;
        //this.grid = grid;
        this.pregunta=pregunta;
        this.lbl1=lbl1;
        this.lbl2=lbl2;
        this.lbl3=lbl3;
        this.lbl4=lbl4;
        this.lbl0=lbl0;
        this.slct=slct;
        //this.text = text;
    }

    public boolean isSlct() {
        return slct;
    }

    public void setSlct(boolean slct) {
        this.slct = slct;
    }
    
    

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas =respuestas;
    }

    public GridPane getGrid() {
        return grid;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }
    
    /**
     * obtiene las respuestas de la pregunta
     * @param p
     * @return 
     */
    private ArrayList<String> obtRespuestas(Pregunta p){
        ArrayList<String> respuestas= new ArrayList<String>();
        ArrayList<String> rptsaleatorias= new ArrayList<String>();
        respuestas.add(p.getPosible_respuesta1());
        respuestas.add(p.getPosible_respuesta2());
        respuestas.add(p.getPosible_respuesta3());
        respuestas.add(p.getRepuesta_correcta());

        int cont=0;
        while(cont<4){
            Random aleatorio = new Random(System.currentTimeMillis());
            int numAleatorio = aleatorio.nextInt(respuestas.size());
            if(!(rptsaleatorias.contains(respuestas.get(numAleatorio)))){
                rptsaleatorias.add(respuestas.get(numAleatorio));
                respuestas.remove(numAleatorio);
                cont++;
            }
            
        }
        return rptsaleatorias;
        
    }
    
    /**
     * detiene el hilo cronometro
     */
    private void detener(){
        if(detener){
            //System.out.println("jijij");
            cronometro.stop();
            
        }
    }
    
    /**
     * lo que se ejecutara en el hilo cambia Grid
     */
    @Override
    public void run() {

        for(Pregunta p: preguntas3){
            //detener=false;
            
            ArrayList<String> rpts= obtRespuestas(p);

            //slt=false;
            Platform.runLater(() -> { 
                //slt=false;
                String preg = p.getEnunciado();
                pregunta.setText(preg);
                
                for(int i = 0; i <= rpts.size(); i++){

                    if(i==0){
                        //System.out.println(rpts.get(i));
                        String r1 = rpts.get(i);
                        lbl1.setText(r1);
                    }
                    if(i==1){
                        //System.out.println(rpts.get(i));
                        String r2 = rpts.get(i);
                        lbl2.setText(r2);
                    }
                    if(i==2){
                        //System.out.println(rpts.get(i));
                        String r3 = rpts.get(i);
                        lbl3.setText(r3);
                    }
                    if(i==3){
                        //System.out.println(rpts.get(i));
                        String r4 = rpts.get(i);
                        lbl4.setText(r4);
                    }
                    //detener=false;
                    cronometro = new Thread(new Cronometro(60,lbl0,true,slct));
                    cronometro.setDaemon(true);
                    cronometro.start();
                    detener();
                    
                    //siesta();
                    



                }
            });
            
            contador++;
            
            siesta();
            //cronometro.setDaemon(true);
            
        }
        
        try {
            App.setRoot("gracia");
            contador++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
    /**
     * duerme por 15 segundos
     */
    public void siesta(){
       
        try {
            sleep(15000);
        } catch (InterruptedException ex) {
            System.out.println("error en sleep");
        }
        
    }
    
}
