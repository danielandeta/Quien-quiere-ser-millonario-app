/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevo_juego;

import configuraciones.Pregunta;

/**
 *
 * @author DELL
 */
public class PreguntaEnJuego {
    
    private Pregunta pregunta;
    private boolean contestada;

    public PreguntaEnJuego(Pregunta pregunta, boolean contestada) {
        this.pregunta = pregunta;
        this.contestada = contestada;
    }
    
    public PreguntaEnJuego(){}

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isContestada() {
        return contestada;
    }

    public void setContestada(boolean contestada) {
        this.contestada = contestada;
    }

    @Override
    public String toString() {
        return "PreguntaEnJuego{" + "pregunta=" + pregunta.getEnunciado() + ", contestada=" + contestada + '}';
    }
    
    
    
}
