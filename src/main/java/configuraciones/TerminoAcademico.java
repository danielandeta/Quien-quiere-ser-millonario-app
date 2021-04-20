/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuraciones;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class TerminoAcademico {
    
    private String anio;
    private String numero;
    private ArrayList<Paralelo> paralelos;

    public TerminoAcademico(String anio, String numero) {
        this.anio = anio;
        this.numero = numero;
    }
    
    public TerminoAcademico(){}

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return anio + "-" + numero ;
    }
    
}
