package com.grupo7.gameespolapp;

import static com.grupo7.gameespolapp.AgregarparaleloController.paralelos;
import static com.grupo7.gameespolapp.EditarterminoController.terminos;
import static com.grupo7.gameespolapp.GraciaController.reportes;
import static com.grupo7.gameespolapp.IngresarmatController.materias;
import configuraciones.Estudiante;
import configuraciones.Materia;
import configuraciones.Paralelo;
import configuraciones.TerminoAcademico;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import nuevo_juego.Juego;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    //public static ArrayList<TerminoAcademico> terminos;

    @Override
    public void start(Stage stage) throws IOException {
        TerminoAcademico termino= new TerminoAcademico("2020","1");
        Materia materia= new Materia("POO","CCPG1052","3",true);
        Materia materia1= new Materia("NOMBRE","CODIGO","NIVEL",false);
        ArrayList<Estudiante> estudiantes= new ArrayList<Estudiante>();
        //ArrayList<Juego> reportes1= new ArrayList<Juego>();
        Estudiante e=new Estudiante("000","name","email");
        estudiantes.add(e);
        Paralelo paralelo= new Paralelo(materia, termino, "2",estudiantes);
        materias.add(materia);
        terminos.add(termino);
        paralelos.add(paralelo);
        reportes.add(new Juego("Fecha /"," Participante /"," Nivel /"," Premio"));
        scene = new Scene(loadFXML("principal"), 1280, 720);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        
    }

}