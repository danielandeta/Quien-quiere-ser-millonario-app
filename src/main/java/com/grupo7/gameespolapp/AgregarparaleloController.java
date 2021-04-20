/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.EditarterminoController.terminos;
import static com.grupo7.gameespolapp.IngresarmatController.materias;
import configuraciones.Estudiante;
import configuraciones.Materia;
import configuraciones.Paralelo;
import configuraciones.TerminoAcademico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AgregarparaleloController implements Initializable {
    
    public static ArrayList<Paralelo> paralelos= new ArrayList<Paralelo>();
    ArrayList<Estudiante> estudiantes1= new ArrayList<Estudiante>();
    @FXML
    ListView lvMaterias;
    
    @FXML
    ListView lvTerminos;
    
    @FXML
    TextField txtparalelo;
    
    String cod_mat;
    String anio;
    String term_num;
    String num_par;
    
    //TerminoAcademico ter= new TerminoAcademico();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvMaterias.getItems().setAll(materias);
        lvTerminos.getItems().setAll(terminos);
    }    
    
    /**
     * cambia de ventana al menu de materia
     * @throws IOException 
     */
    @FXML
    private void switchMateria() throws IOException {
        App.setRoot("materia");
    }
    
    /**
     * selecciona un termino del listview
     * @throws IOException 
     */
    @FXML
    private void seleccionTermino() throws IOException {
        TerminoAcademico ter= (TerminoAcademico) lvTerminos.getSelectionModel().getSelectedItem();
        anio= ter.getAnio();
        term_num=ter.getNumero();
        
        
    }
    
    /**
     * selecciona materia del listview
     * @throws IOException 
     */
    @FXML
    private void seleccionMat() throws IOException {
        Materia mat= (Materia) lvMaterias.getSelectionModel().getSelectedItem();
        cod_mat= mat.getCodigo();
    }
    
    
    /**
     * permite escoger un documento desde el ordenador
     * @throws IOException 
     */
    @FXML
    public void abrirDialogo() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        System.out.println(selectedFile.getAbsolutePath());
        String origenArchivo = selectedFile.getAbsolutePath().replace("\\", "/");
        System.out.println(origenArchivo);
        String rute = cod_mat+"-"+txtparalelo.getText()+"-"+anio+"-"+term_num+".csv";
        String destinoArchivo = "src/main/java/archivos/"+rute;
        try {
            
            String fichero = "prueba";
            File fileOrigen = new File(origenArchivo);
            File fileDestino = new File(destinoArchivo);

            Files.copy(Paths.get(fileOrigen.getAbsolutePath()), Paths.get(fileDestino.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
            
            leerEstudiantes();

            Paralelo par= new Paralelo();
            for(TerminoAcademico ta:terminos){
                if (((ta.getAnio()).equals(anio))&&((ta.getNumero()).equals(term_num))){
                    par.setTermino(ta);
                }
            }
            for(Materia mat:materias){
                if ((mat.getCodigo()).equals(cod_mat)){
                    par.setMateria(mat);
                }
            }
            par.setParaleloCod(txtparalelo.getText());
            par.setEstudiantes(estudiantes1);
            paralelos.add(par);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operacion");
            alert.setContentText("Lista de estudiantes agregada exitosamente");

            alert.showAndWait();
            App.setRoot("materia");
            
        } catch (FileNotFoundException ex) {
            System.out.println("err");
        } catch (IOException ex) {
            System.out.println("errrrrrrrrr"+ex);

        }
    }
    
    /**
     * lee lista de estudiante 
     * @throws IOException 
     */
    private void leerEstudiantes() throws IOException{
        BufferedReader csvReader = null;
        try {
            
            String rute = cod_mat+"-"+txtparalelo.getText()+"-"+anio+"-"+term_num+".csv";
            System.out.println("f");
            String ruta = "src/main/java/archivos/"+rute; //ruta del archivo que se va a leer
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila = csvReader.readLine();//escapar cabecera de archivo
            System.out.println("i");
            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                String[] data = fila.split(";");
                estudiantes1.add(new Estudiante(data[0], data[1], data[2])); //crear objeto y agregar a lista

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