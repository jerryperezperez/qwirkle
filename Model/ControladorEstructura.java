package Model;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Array;
import java.util.*;

public class ControladorEstructura {
    private ArrayList<Estructura> estructuraFilas;
    private ArrayList<Estructura> estructuraColumnas;

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
            for (Casilla casilla : estructuraFila.getCola()) {
                System.out.println(casilla.toString());
            }
        }
        System.out.println("IMPRIMIENDO ESTRUCTURA DE COLUMNAS");
        for (Estructura estructuraColumna : this.estructuraColumnas) {
            System.out.println("IMPRIMIENDO UNA COLUMNA");
            for (Casilla casilla : estructuraColumna.getCola()) {
                System.out.println(casilla.toString());
            }
        }
    }

    public void crearEstructuraFila(Casilla casilla) {
        if (casilla.getCasillaIzquierda().getFicha() == null && casilla.getCasillaDerecha().getFicha() == null) {
            this.estructuraFilas.add(new Estructura(casilla));
        }
    }

    public void crearEstructuraColumna(Casilla casilla) {
        if (casilla.getCasillaSuperior().getFicha() == null && casilla.getCasillaInferior().getFicha() == null) {
            this.estructuraColumnas.add(new Estructura(casilla));
        }
    }

    public int agregar(Casilla casilla, Ficha ficha) throws Exception {

        if (casilla.getCasillaIzquierda().getFicha() != null && casilla.getCasillaDerecha().getFicha() != null) {
            if (this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getRestriccion().equals(this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getRestriccion())) {

            } else {
                throw new Exception("TIENEN DIFERENTES RESTRICCIONES LAS COLAS, NO ES POSIBLE SU UNIÓN.");
            }
        }
        if (casilla.getCasillaIzquierda().getFicha() != null) {
            this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).isDuplicated(ficha);
            if (!this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).estaCondicionada()) {
                System.out.println("ENTRA EN PRIMER IF de casilla izquierda");
                this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).designarRestriccion(ficha);
            } else {
                System.out.println("ENTRA EN ELSE");
                this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getCola().addLast(casilla);
          //  System.out.println("PUNTOS GANADOS EN HORIZONTAL: " + this.recuperarEstructuraInicial(this.estructuraFilas, casilla).getCola().size());
        }
        if (casilla.getCasillaDerecha().getFicha() != null) {
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).isDuplicated(ficha);
            if (!this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).estaCondicionada()) {
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).designarRestriccion(ficha);
                System.out.println("ENTRA EN PRIMER IF");
            } else {
                System.out.println("ENTRA EN PRIMER ELSE");
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getCola().addFirst(casilla);
           // System.out.println("PUNTOS GANADOS EN HORIZONTAL: " + this.recuperarEstructuraFinal(this.estructuraFilas, casilla).getCola().size());

        }
        if (casilla.getCasillaSuperior().getFicha() != null) {
            this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).isDuplicated(ficha);
            if (!this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).estaCondicionada()) {
                System.out.println("ENTRA EN PRIMER IF");
                this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).designarRestriccion(ficha);
            } else {
                System.out.println("ENTRA EN ELSE");
                this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).getCola().addLast(casilla);
           // System.out.println("PUNTOS GANADOS EN VERTICAL: " + this.recuperarEstructuraInicial(this.estructuraColumnas, casilla).getCola().size());

        }
        if (casilla.getCasillaInferior().getFicha() != null) {
            this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).isDuplicated(ficha);
            if (!this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).estaCondicionada()) {
                this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).designarRestriccion(ficha);
                System.out.println("ENTRA EN PRIMER IF");
            } else {
                System.out.println("ENTRA EN PRIMER ELSE");
                this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).getCola().addFirst(casilla);
            //System.out.println("PUNTOS GANADOS EN VERTICAL: " + this.recuperarEstructuraFinal(this.estructuraColumnas, casilla).getCola().size());

        }
        this.crearEstructuraFila(casilla);
        this.crearEstructuraColumna(casilla);
        this.imprimirEstructuras();
        casilla.setFicha(ficha);
        System.out.println("PUNTOS GANADOS:     " + this.recuperarLongitudEstructura(casilla));

        return this.recuperarLongitudEstructura(casilla);
    }

    public int recuperarLongitudEstructura(Casilla casilla){
        int puntos= 0;
        for (Estructura estructuraFila: this.estructuraFilas) {
            if (estructuraFila.getCola().contains(casilla)){
                if (estructuraFila.getCola().size()>1){
                    puntos = puntos + estructuraFila.getCola().size();
                }
            }
        }
        for (Estructura estructuraColumna: this.estructuraColumnas) {
            if (estructuraColumna.getCola().contains(casilla)){
                if (estructuraColumna.getCola().size()>1){
                    puntos = puntos + estructuraColumna.getCola().size();
                }
            }
        }
        return puntos;
    }

    public Estructura recuperarEstructuraFinal(ArrayList<Estructura> estructuras, Casilla casilla) throws Exception {
        for (Estructura estructura : estructuras) {
            if (estructura.getCola().getFirst().getFicha().getId() == casilla.getFicha().getId()) {
                return estructura;
            }
        }
        throw new Exception("NO HAY COLA IZQUIERDA");
    }

    public Estructura recuperarEstructuraInicial(ArrayList<Estructura> estructuras, Casilla casilla) throws Exception {
        for (Estructura estructura : estructuras) {
            if (estructura.getCola().getLast().getFicha().getId() == casilla.getFicha().getId()) {
                return estructura;
            }
        }
        throw new Exception("NO HAY COLA DERECHA");
    }

}


