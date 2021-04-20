/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevo_juego;

import utileria.TipoComodin;

/**
 *
 * @author DELL
 */
public class ComodinEnJuego {
    
    private TipoComodin comodin;
    private boolean usado;

    public ComodinEnJuego(TipoComodin comodin, boolean usado) {
        this.comodin = comodin;
        this.usado = usado;
    }

    public TipoComodin getComodin() {
        return comodin;
    }

    public void setComodin(TipoComodin comodin) {
        this.comodin = comodin;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    @Override
    public String toString() {
        return "ComodinEnJuego{" + "comodin=" + comodin + ", usado=" + usado + '}';
    }
    
}
