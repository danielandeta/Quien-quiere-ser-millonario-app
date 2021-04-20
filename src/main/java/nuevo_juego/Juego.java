/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevo_juego;

import configuraciones.Estudiante;
import configuraciones.Paralelo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Juego {
    
    private Paralelo paralelo;
    private String fecha;
    private int preguntasPorNivel;
    private String nivelAlcanzado;
    private String premio;
    private Estudiante participante;
    private Estudiante compañero;
    private ArrayList<ComodinEnJuego> comodines;
    private ArrayList<PreguntaEnJuego> preguntas;
    String participante0;
    
    public Juego(String fecha, String participante0, String nivelAlcanzado, String premio){
        this.fecha=fecha;
        this.participante0= participante0;
        this.nivelAlcanzado=nivelAlcanzado;
        this.premio=premio;
        
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Estudiante getParticipante() {
        return participante;
    }

    public void setParticipante(Estudiante participante) {
        this.participante = participante;
    }

    public String getNivelAlcanzado() {
        return nivelAlcanzado;
    }

    public void setNivelAlcanzado(String niveMaximoAlcanzado) {
        this.nivelAlcanzado = niveMaximoAlcanzado;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return fecha + " / " +participante0+" / " + nivelAlcanzado + " / " + premio  ;
    }
    
    


}
