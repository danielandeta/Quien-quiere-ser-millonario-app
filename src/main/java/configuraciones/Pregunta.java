/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuraciones;

/**
 *
 * @author DELL
 */
public class Pregunta implements Comparable<Pregunta>{
    private String enunciado;
    private String nivel;
    private String repuesta_correcta;
    private String posible_respuesta1;
    private String posible_respuesta2;
    private String posible_respuesta3;
    private Materia materia;

    public Pregunta(Materia materia, String enunciado, String nivel, String repuesta_correcta, String posible_respuesta1, String posible_respuesta2, String posible_respuesta3) {
        this.enunciado = enunciado;
        this.nivel = nivel;
        this.repuesta_correcta = repuesta_correcta;
        this.posible_respuesta1 = posible_respuesta1;
        this.posible_respuesta2 = posible_respuesta2;
        this.posible_respuesta3 = posible_respuesta3;
        this.materia=materia;
    }
    
    public Pregunta(){}

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    

    @Override
    public String toString() {
        return materia.getCodigo()+"--" +enunciado +"-"+ nivel + "\ncorrecta: " + repuesta_correcta + "\nincorrectas: " +posible_respuesta1 +"-"+ posible_respuesta2 + "-"+ posible_respuesta3 ;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getRepuesta_correcta() {
        return repuesta_correcta;
    }

    public void setRepuesta_correcta(String repuesta_correcta) {
        this.repuesta_correcta = repuesta_correcta;
    }

    public String getPosible_respuesta1() {
        return posible_respuesta1;
    }

    public void setPosible_respuesta1(String posible_respuesta1) {
        this.posible_respuesta1 = posible_respuesta1;
    }

    public String getPosible_respuesta2() {
        return posible_respuesta2;
    }

    public void setPosible_respuesta2(String posible_respuesta2) {
        this.posible_respuesta2 = posible_respuesta2;
    }

    public String getPosible_respuesta3() {
        return posible_respuesta3;
    }

    public void setPosible_respuesta3(String posible_respuesta4) {
        this.posible_respuesta3 = posible_respuesta4;
    }

    @Override
    public int compareTo(Pregunta o) {
        return nivel.compareTo(o.getNivel());
    }

    
}
