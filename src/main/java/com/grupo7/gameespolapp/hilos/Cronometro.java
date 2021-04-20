/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp.hilos;

import com.grupo7.gameespolapp.App;
import static com.grupo7.gameespolapp.JuegoController.slt;
import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author DELL
 */
public class Cronometro extends Thread{
    
    private int tiemp;
    Label tiempo;
    boolean activo=true;
    private boolean selec;
    public static boolean detener=false;
    
    public Cronometro(int tiemp, Label tiempo, boolean activo, boolean selec){
        this.tiemp=tiemp;
        this.tiempo=tiempo;
        this.activo=activo;
        this.selec=selec;
    }
    
    /**
     * cronometro de 10 segundos
     */
    @Override
    public void run() {
        //while(true){
        //detener=false;
        activo = true;
        //slt=false;
        try {
            if(tiemp>0)
            Thread.sleep(5000);
            slt=false;
        } catch (InterruptedException ex) {

        }
        tiemp=11;
        Platform.runLater(() ->{
            tiempo.setText("10");
        });
        while(activo){
            try {
                if(tiemp>0)
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
            tiemp -= 1;
            Platform.runLater(() ->{
                //System.out.println(tiemp);
                if(tiemp==1){
                    //slt=false;

                    tiempo.setText("00");
                    activo= false;
                    
                    if(slt ==false){
                        detener=true;
                        System.out.println("no respo");
                        try {
                            App.setRoot("gracia");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    
                
                }else if(tiemp < 11 && tiemp>1){
                    tiempo.setText(Integer.toString((int) tiemp-1));
                }
                
                
            });
            //slt=false;
            
        }

        

    }


    /**
     * el hilo se duerme por 2 segundos
     */
    public void siesta(){
       
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("error en sleep");
        }
        
    }
    
    
}
