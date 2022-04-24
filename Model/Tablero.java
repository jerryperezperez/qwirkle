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

    public Casilla ponerFicha(Ficha fichaSeleccionada, int x, int y){
        // Aqui debe ir la casilla clicada
        if (fichaSeleccionada != null){
            this.casilla[x][y].setFicha(fichaSeleccionada);
            System.out.println("casilla = " + casilla[x][y].getFicha().getColor() + " " + casilla[x][y].getFicha().getForma() + " " +casilla[x][y].getFicha().getId() + "  X Y: "+x+ " "+y) ;
        }
        return this.casilla[x][y];
    }

}
