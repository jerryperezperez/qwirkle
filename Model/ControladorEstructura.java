package Model;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Array;
import java.util.*;

public class ControladorEstructura {
    private ArrayList<EstructuraFila> estructuraFilas;
    private ArrayList<EstructuraColumna> estructuraColumnas;

    public ControladorEstructura(Casilla casilla) {
        this.estructuraColumnas = new ArrayList<>();
        this.estructuraFilas = new ArrayList<>();
        this.estructuraFilas.add(new EstructuraFila(casilla));
        this.estructuraColumnas.add(new EstructuraColumna(casilla));
    }

    public void imprimirEstructuras() {
        System.out.println("IMPRIMIENDO ESTRUCTURA DE FILAS");
        for (Estructura estructuraFila : this.estructuraFilas) {
            System.out.println("IMPRIMIENDO UNA FILA");
            for (Casilla casilla : estructuraFila.getColas()) {
                System.out.println(casilla.toString());
            }
        }
        System.out.println("IMPRIMIENDO ESTRUCTURA DE COLUMNAS");
        for (Estructura estructuraColumna : this.estructuraColumnas) {
            System.out.println("IMPRIMIENDO UNA COLUMNA");
            for (Casilla casilla : estructuraColumna.getColas()) {
                System.out.println(casilla.toString());
            }
        }
    }

    public boolean agregar(Casilla casilla, Ficha ficha) throws Exception {
        for (EstructuraFila estructuraFila : this.estructuraFilas) {
            if (estructuraFila.agregarEnColaDerecha(casilla, ficha)) {
                if (casilla.getCasillaSuperior().getFicha() == null && casilla.getCasillaInferior().getFicha() == null) {
                    this.estructuraColumnas.add(new EstructuraColumna(casilla));
                }

            } else {
                if (estructuraFila.agregarEnColaIzquierda(casilla, ficha)) {
                    if (casilla.getCasillaSuperior().getFicha() == null && casilla.getCasillaInferior().getFicha() == null) {
                        this.estructuraColumnas.add(new EstructuraColumna(casilla));
                    }
                }
            }
        }
        for (EstructuraColumna estructuraColumna : this.estructuraColumnas) {
            if (estructuraColumna.agregarEnColaSuperior(casilla, ficha)) {
                if (casilla.getCasillaIzquierda().getFicha() == null && casilla.getCasillaDerecha().getFicha() == null) {
                    this.estructuraFilas.add(new EstructuraFila(casilla));
                }

            } else {
                if (estructuraColumna.agregarEnColaInferior(casilla, ficha)) {
                    if (casilla.getCasillaIzquierda().getFicha() == null && casilla.getCasillaDerecha().getFicha() == null) {
                        this.estructuraFilas.add(new EstructuraFila(casilla));
                    }
                }
            }
        }
        return true;
    }

}


