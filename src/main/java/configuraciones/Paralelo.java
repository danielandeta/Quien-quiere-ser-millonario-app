/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuraciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Paralelo {
    
    private String paraleloCod;
    private ArrayList<Estudiante> estudiantes= new ArrayList<>();
    private Materia materia=new Materia();
    private TerminoAcademico termino;

    public Paralelo(Materia materia,TerminoAcademico termino,String paraleloCod,ArrayList<Estudiante> estudiantes) {
        this.paraleloCod = paraleloCod;
        this.materia=materia;
        this.termino = termino;
        this.estudiantes=estudiantes;
    }

    public Paralelo() {
    }


    public String getParaleloCod() {
        return paraleloCod;
    }

    public void setParaleloCod(String paraleloCod) {
        this.paraleloCod = paraleloCod;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public TerminoAcademico getTermino() {
        return termino;
    }

    public void setTermino(TerminoAcademico termino) {
        this.termino = termino;
    }

    @Override
    public String toString() {
        return materia.getCodigo()+"-"+paraleloCod+"-"+termino.getAnio()+"-"+termino.getNumero();
    }
    
    
    
}
