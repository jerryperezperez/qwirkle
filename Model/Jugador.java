/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class Jugador {

    static int ID;
    private int idJugador;
    public ArrayList<Ficha> fichas;
    private int puntosJugador;
    private int manoJugador;
    private Ficha fichaSeleccionada;
    private Ficha fichaVacia;
    private int cantidadFichasSeleccionadas;
    private int puntosObtenidos;

    public Jugador() {
        this.idJugador = Jugador.ID;
        Jugador.ID += 1;
        this.fichas = new ArrayList<>();
        fichaVacia = new Ficha();
        this.puntosJugador = 0;
    }

    public void sumarPuntos(int puntos) {
        this.puntosJugador = puntos;
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

    public void removerFichaSeleccionada() {
        this.fichaSeleccionada = null;
    }

    public void quitarFichasJugadas() {
        System.out.println("longitud: " + this.fichas.size());
        for (int i = 0; i < 6; i++) {
            this.fichas.remove(fichaVacia);
        }
        System.out.println("longitud: " + this.fichas.size());
    }

    public int getCantidadFichasSeleccionadas() {
        return cantidadFichasSeleccionadas;
    }

    public int getIdFicha(int i) {
        return this.fichas.get(i).getId();
    }

    public Ficha[] getArregloFichas() {
        return this.fichas.toArray(new Ficha[this.fichas.size()]);
    }

    public Ficha devolverFicha() {
        return this.fichas.remove(1);
    }

    public void removerFicha(Ficha ficha) {
        //this.fichas.remove(ficha);
        for (int i = 0; i < 6; i++) {
            if (ficha == this.fichas.get(i)) {
                this.fichas.set(i, fichaVacia);
            }
        }
    }

    public void setCantidadFichasSeleccionadas(int cantidadFichasSeleccionadas) {
        this.cantidadFichasSeleccionadas = cantidadFichasSeleccionadas;
    }
}