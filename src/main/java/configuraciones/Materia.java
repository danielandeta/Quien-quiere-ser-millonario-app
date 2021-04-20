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
public class Materia {
    private  String nombre;
    private String codigo;
    private String cantidadNiveles;
    private boolean activo;
    public ArrayList<Pregunta> preguntas;

    public Materia(String nombre, String codigo, String cantidadNiveles, boolean activo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadNiveles = cantidadNiveles;
        this.activo = activo;
    }

    public Materia(){}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCantidadNiveles() {
        return cantidadNiveles;
    }

    public void setCantidadNiveles(String cantidadNiveles) {
        this.cantidadNiveles = cantidadNiveles;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return  nombre + "-" + codigo +  "-" +cantidadNiveles+"-"+ activo ;
    }

    
}
