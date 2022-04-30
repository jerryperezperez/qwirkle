package Model;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Array;
import java.util.*;

public class Estructura {
    private ArrayList<EstructuraFila> estructuraFilas;
    private ArrayList<EstructuraColumna> estructuraColumnas;

    public Estructura(Casilla casilla) {
        this.estructuraColumnas = new ArrayList<>();
        this.estructuraFilas = new ArrayList<>();
        this.estructuraFilas.add(new EstructuraFila(casilla));
        this.estructuraColumnas.add(new EstructuraColumna(casilla));
        //  this.imprimirEstructuras();
    }

    public void imprimirEstructuras() {

        System.out.println(this.estructuraFilas.size());
        System.out.println(this.estructuraColumnas.size());
        System.out.println("IMPRIMIENDO ESTRUCTURA DE FILAS");
        for (EstructuraFila estructuraFila : this.estructuraFilas) {
            for (Casilla casilla : estructuraFila.getFilas()) {
                System.out.println(casilla.toString());
            }
        }
        System.out.println("IMPRIMIENDO ESTRUCTURA DE COLUMNAS");
        for (EstructuraColumna estructuraColumna : this.estructuraColumnas) {
            for (Casilla casilla : estructuraColumna.getColumnas()) {
                System.out.println(casilla.toString());
            }
        }
    }

    public boolean agregar(Casilla casilla, Ficha ficha) {
        // System.out.println("entra en método agregar");
        if (this.agregarEnEstructuraFila(casilla, ficha)) {
            return true;
        } else {
            return false;
        }
    }

    //agregarEstructuraFila
    private boolean agregarEnEstructuraFila(Casilla casilla, Ficha ficha) {
        if (this.agregarEnColaDerecha(casilla, ficha) && this.agregarEnColaIzquierda(casilla, ficha)){
            this.estructuraColumnas.add(new EstructuraColumna(casilla));
        }
        for (EstructuraFila estructuraFila : this.estructuraFilas) {
            if (casilla.getCasillaIzquierda().getFicha() != null) {
                if (estructuraFila.getFilas().getLast().getFicha().getId() == casilla.getCasillaIzquierda().getFicha().getId()) {
                    if (!estructuraFila.addToRight(casilla, ficha)) {
                        return false;
                    } else {
                        this.estructuraColumnas.add(new EstructuraColumna(casilla));
                    }
                }
            }
            if (casilla.getCasillaDerecha().getFicha() != null) {
                if (estructuraFila.getFilas().getFirst().getFicha().getId() == casilla.getCasillaDerecha().getFicha().getId()) {
                    if (!estructuraFila.addToLeft(casilla, ficha)) {
                        return false;
                    } else {
                        this.estructuraColumnas.add(new EstructuraColumna(casilla));
                    }
                }
            }
        }
 /*       if (casilla.getCasillaIzquierda().getFicha() != null) {
            for (EstructuraFila estructuraFila : this.estructuraFilas) {
                if (estructuraFila.getFilas().getLast().getFicha().getId() == casilla.getCasillaIzquierda().getFicha().getId()) {
                    if (!estructuraFila.addToRight(casilla, ficha)) {
                        return false;
                    } else {
                        this.estructuraColumnas.add(new EstructuraColumna(casilla));
                    }
                }
            }
        }
        if (casilla.getCasillaDerecha().getFicha() != null) {
            for (EstructuraFila estructuraFila : this.estructuraFilas) {
                if (estructuraFila.getFilas().getFirst().getFicha().getId() == casilla.getCasillaDerecha().getFicha().getId()) {
                    if (!estructuraFila.addToLeft(casilla, ficha)) {
                        System.out.println("NO SE HA AGREGADO A LA IZQUIERDA");
                        return false;
                    } else {
                        this.estructuraFilas.add(new EstructuraFila(casilla));
                        System.out.println("cantidad de estructuras en columnas: " + this.estructuraColumnas.size());
                    }
                }
            }
        }*/
        return true;
    }

    public boolean agregarEnColaIzquierda(Casilla casilla, Ficha ficha) {
        for (EstructuraFila estructuraFila : this.estructuraFilas) {
            if (casilla.getCasillaIzquierda().getFicha() != null) {
                if (estructuraFila.getFilas().getLast().getFicha().getId() == casilla.getCasillaIzquierda().getFicha().getId()) {
                    if (!estructuraFila.addToRight(casilla, ficha)) {
                        return false;
                    } else {
                        this.estructuraColumnas.add(new EstructuraColumna(casilla));

                    }
                }
            }
        }
        return true;
    }

    public boolean agregarEnColaDerecha(Casilla casilla, Ficha ficha) {
        for (EstructuraFila estructuraFila : this.estructuraFilas) {
            if (casilla.getCasillaDerecha().getFicha() != null) {
                if (estructuraFila.getFilas().getFirst().getFicha().getId() == casilla.getCasillaDerecha().getFicha().getId()) {
                    if (!estructuraFila.addToLeft(casilla, ficha)) {
                        return false;
                    } else {
                        this.estructuraColumnas.add(new EstructuraColumna(casilla));
                    }
                }
            }
        }
        return true;
    }

    public void agregarEnEstructura(EstructuraFila estructura, Ficha ficha) {

    }

    public void detectarFichasSuperiores() {

    }


  /*  public void buscarEnColumnas(ArrayList<Ficha> columnas, Casilla casilla) {
        for (EstructuraColumna estructuraColumna: this.columnas) {
            estructuraColumna.contains(casilla);
        }
    }

    public boolean contains(Casilla casilla) {
        if (!this.filas.contains(casilla)) {
            if (!this.columnas.contains(casilla)) {
                System.out.println("no lo contiene ninguna estructura");
                return false;
            }
        }
        System.out.println("lo contiene ambas estructuras");
        return true;
    }*/


}


