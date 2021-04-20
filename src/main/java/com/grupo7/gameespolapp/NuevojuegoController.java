/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.AgregarparaleloController.paralelos;
import static com.grupo7.gameespolapp.IngresarmatController.materias;
import configuraciones.Estudiante;
import configuraciones.Materia;
import configuraciones.Paralelo;
import configuraciones.Pregunta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class NuevojuegoController implements Initializable {
    
    public static ArrayList<Pregunta> preguntas2= new ArrayList<Pregunta>();
    public static ArrayList<Pregunta> preguntas3= new ArrayList<Pregunta>();
    public static ArrayList<Estudiante> estudiantes2=new ArrayList<Estudiante>();
    
    public static ArrayList<Estudiante> estudiantes3=new ArrayList<Estudiante>();
    @FXML
    ListView lvMaterias;
    
    @FXML
    ListView lvParalelos;
    
    Materia mat;
    
    String cod0;
    public static String par0;
    
    @FXML
    TextField cod_participante;
    
    @FXML
    TextField cod_apoyo;
    
    @FXML
    TextField numxnivel;
    
    @FXML
    private MenuButton compapoyo;
    
    @FXML
    Label idaleatorio;
    public static Estudiante participante;
    public static Estudiante apoyo0;
    
    public static int numerador;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvMaterias.getItems().setAll(materias);
        lvParalelos.getItems().setAll(paralelos);
    }    
    
    
    private void companieros(){
        for(Estudiante e: estudiantes2){
            String s=e.getMatricula();
            MenuItem mi=new MenuItem(s);
            mi.setOnAction((ev)->{
                apoyo0=e;
                compapoyo.setText(s);

            });
            compapoyo.getItems().add(mi);
            
        }
    }
    /**
     * cambia de ventana a menu principal
     * @throws IOException 
     */
    public void switchToPrimary() throws IOException {
        App.setRoot("principal");
    }
    
    /**
     * cambia de ventana al juego
     * @throws IOException 
     */
    public void switchToIniciar() throws IOException {
        ordenarPreguntas();
        //System.out.println(preguntas3);
        escogerEstudiantes();
        App.setRoot("juego");
    }
    
    /**
     * selecciona materia del list view
     * @throws IOException 
     */
    @FXML
    public void seleccionMateria() throws IOException {
        Materia m = (Materia) lvMaterias.getSelectionModel().getSelectedItem();
        cod0 = m.getCodigo();
        mat=m;

        leerPreguntas();
    }
    
    /**
     * selecciona paralelo del list view
     */
    @FXML
    public void seleccionParalelo() throws IOException {
        Paralelo p = (Paralelo) lvParalelos.getSelectionModel().getSelectedItem();
        par0 = p.toString();
        leerEstudiantes();
        companieros();
    }
    
    /**
     * lee las preguntas segun el codigo de la materia
     * @throws IOException 
     */
    private void leerPreguntas() throws IOException{
        BufferedReader csvReader = null;
        try {
            
            String rute = cod0+".csv";

            String ruta = "src/main/java/archivos/"+rute; //ruta del archivo que se va a leer
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila = csvReader.readLine();//escapar cabecera de archivo
            
            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                
                String[] data = fila.split(";");
                preguntas2.add(new Pregunta(mat,data[0], data[1], data[2], data[3],data[4],data[5])); //crear objeto y agregar a lista

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
    
    /**
     * ordena las preguntas q van a ser usadas en el juego segun la cantidad 
     */
    private void ordenarPreguntas(){
        String nivel= mat.getCantidadNiveles();
        int nivel1=Integer.parseInt(nivel); 
        System.out.println("Cantidad de niveles ="+nivel1);
        
        String cant= numxnivel.getText();
        int cant2= Integer.parseInt(cant);
        numerador=cant2;
        
        //int cont=0;
        for(int i=1;i<=nivel1;i++){
            int cont =0;

            for(Pregunta pr:preguntas2){
                int nivel0=Integer.parseInt(pr.getNivel());

                    
                if(nivel0==i){
                    cont++;
                  
                    if (cont<=cant2){
                       preguntas3.add(pr); 
                    }
                    
                    //cont++;
                    //System.out.println("contador dentro del if = "+cont);
                }
                
            }//System.out.println("Cotador fuera del FOR ="+cont);
        }
     
    }
    
    /**
     * lee el archivo de estudiantes
     * @throws IOException 
     */
    private void leerEstudiantes() throws IOException{
        BufferedReader csvReader = null;
        try {
            
            String rute = par0+".csv";
            System.out.println("f");
            String ruta = "src/main/java/archivos/"+rute; //ruta del archivo que se va a leer
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila = csvReader.readLine();//escapar cabecera de archivo
            System.out.println("i");
            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                String[] data = fila.split(";");
                estudiantes2.add(new Estudiante(data[0], data[1], data[2])); //crear objeto y agregar a lista

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
    
    /**
     * escoge los estudiantes el que participa y el de apoyo
     */
    private void escogerEstudiantes(){
        String part= cod_participante.getText();
        //String apoy= cod_apoyo.getText();
        estudiantes3.add(apoyo0);
        for (Estudiante e:estudiantes2){
            if(e.getMatricula().equals(part)){
                participante=e;
                estudiantes3.add(e);
            }
        }
        
    }
    /**
     * genera una matricula aleatoria de la lista de estudiantes
     * @throws IOException 
     */
    @FXML
    private void getRandomEstudiantes()throws IOException {

        Random aleatorio = new Random();
        int numAleatorio = aleatorio.nextInt(estudiantes2.size());
        String part=estudiantes2.get(numAleatorio).getMatricula();
        idaleatorio.setText(estudiantes2.get(numAleatorio).getMatricula());
        cod_participante.setText(part);
    }
    
}
