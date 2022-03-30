/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Jugador {

    static int ID;
    private int idJugador;
    public ArrayList<Ficha> fichas;
    private int puntosJugador;
    private int manoJugador;
    private Ficha fichaSeleccionada;
    private int cantidadFichasSeleccionadas;
    private int puntosObtenidos;

    public Jugador() {
        this.idJugador = Jugador.ID;
        Jugador.ID += 1;
        this.fichas = new ArrayList<>();
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public void setFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }

    public int getPuntosJugador() {
        return puntosJugador;
    }

    public void setPuntosJugador(int puntosJugador) {
        this.puntosJugador = puntosJugador;
    }

    public int getManoJugador() {
        return manoJugador;
    }

    public void setManoJugador(int manoJugador) {
        this.manoJugador = manoJugador;
    }

    public Ficha getFichaSeleccionada() {
        return this.fichaSeleccionada;
    }

    public void setFichaSeleccionada(Ficha fichaSeleccionada) {
        this.fichaSeleccionada = fichaSeleccionada;
    }

    public void removerFichaSeleccionada(){
        this.fichaSeleccionada = null;
    }

    public int getCantidadFichasSeleccionadas() {
        return cantidadFichasSeleccionadas;
    }

    public Ficha[] getFichas() {
        return this.fichas.toArray(new Ficha[this.fichas.size()]);
    }
    public Ficha devolverFicha() {
       return this.fichas.remove(1);
    }
    public void removerFicha(Ficha ficha){
        this.fichas.remove(ficha);
    }

    public void setCantidadFichasSeleccionadas(int cantidadFichasSeleccionadas) {
        this.cantidadFichasSeleccionadas = cantidadFichasSeleccionadas;
    }
}
//MÉTODOS DE RESTRICCIONES PARA PONER, CAMBIAR, ETC.