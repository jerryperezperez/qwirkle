/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;

public class Tablero {

    public final Casilla[][] casilla;
    private int turno;
    private int idGanador;

    public Tablero() {
        this.casilla = new Casilla[24][24];
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                this.casilla[i][j] = new Casilla(i, j);
            }
        }
       
    }

    public int getIdGanador() {
        return idGanador;
    }

    public void setIdGanador(int idGanador) {
        this.idGanador = idGanador;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    public void ponerFicha(Ficha fichaSeleccionada){
        // Aqui debe ir la casilla clicada
        this.casilla[2][2].setFicha(fichaSeleccionada);
        System.out.println("casilla = " + casilla[2][2].getFicha().getColor() + " " + casilla[2][2].getFicha().getForma() + " " +casilla[2][2].getFicha().getId());
    }

}
