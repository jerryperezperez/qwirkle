package Model;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Array;
import java.util.*;

public class ControladorEstructura implements Cloneable{
    private ArrayList<Estructura> estructuraFilas;
    private ArrayList<Estructura> estructuraColumnas;
    private HashSet<Estructura>ultimasEstructurasModificadas;

    public ControladorEstructura(Casilla casilla) {
        this.estructuraColumnas = new ArrayList<>();
        this.estructuraFilas = new ArrayList<>();
        this.estructuraFilas.add(new EstructuraFila(casilla));
        this.estructuraColumnas.add(new EstructuraColumna(casilla));
        ultimasEstructurasModificadas = new HashSet<>();
    }
    public ControladorEstructura(ControladorEstructura controlador){
        this.estructuraColumnas = new ArrayList<>();
        this.estructuraFilas = new ArrayList<>();
        ultimasEstructurasModificadas = new HashSet<>();
        this.clonarEstructuraFila(controlador.estructuraFilas);
        this.clonarEstructuraColumna(controlador.estructuraColumnas);
        this.clonarEstructuraHashSet(controlador.ultimasEstructurasModificadas);
    }

    private void clonarEstructuraFila(ArrayList<Estructura> collection){
        for (Estructura estructura: collection) {
            this.estructuraFilas.add(new Estructura(estructura));
        }
    }
    private void clonarEstructuraColumna(ArrayList<Estructura> collection){
        for (Estructura estructura: collection) {
            this.estructuraColumnas.add(new Estructura(estructura));
        }
    }
    private void clonarEstructuraHashSet(HashSet<Estructura> collection){
        for (Estructura estructura: collection) {
            this.ultimasEstructurasModificadas.add(new Estructura(estructura));
        }
    }


    public void limpiarUltimasEstructurasModificadas(){
        this.ultimasEstructurasModificadas.clear();
    }

    public ArrayList<Estructura> getEstructuraFilas() {
        return (ArrayList<Estructura>) estructuraFilas.clone();
    }

    public ArrayList<Estructura> getEstructuraColumnas() {
        return (ArrayList<Estructura>) estructuraColumnas.clone();
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
            this.ultimasEstructurasModificadas.add(this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()));
            this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getCola().addLast(casilla);
          //  System.out.println("PUNTOS GANADOS EN HORIZONTAL: " + this.recuperarEstructuraInicial(this.estructuraFilas, casilla).getCola().size());
        }
        if (casilla.getCasillaDerecha().getFicha() != null) {
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).isDuplicated(ficha);
            if (!this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).estaCondicionada()) {
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).designarRestriccion(ficha);
                System.out.println("ENTRA EN PRIMER IF de casilla derecha");
            } else {
                System.out.println("ENTRA EN PRIMER ELSE");
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).cumpleRestriccion(ficha);
            }
            //LA RAZÓN POR LA QUE SE AGREGA ANTES QUE SE GUARDE EN LA ORIGINAL ES PORQUE UNA VEZ GUARDADO, AUN NO TIENE FICHA ASIGNADA O LA CASILLA
            //DERECHA DEJA DE SER EL ÚLTIMO O PRIMER ELEMENTO Y POR LO TANTO, NO ENCUENTRA AL ARREGLO Y DEVUELVE NULL
            System.out.println("agregaaaa" + this.ultimasEstructurasModificadas.add(this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha())));
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getCola().addFirst(casilla);
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
            this.ultimasEstructurasModificadas.add(this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()));
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
            this.ultimasEstructurasModificadas.add(this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()));
            this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).getCola().addFirst(casilla);
            //System.out.println("PUNTOS GANADOS EN VERTICAL: " + this.recuperarEstructuraFinal(this.estructuraColumnas, casilla).getCola().size());

        }
        this.crearEstructuraFila(casilla);
        this.crearEstructuraColumna(casilla);
        casilla.setFicha(ficha);


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

    public HashSet<Estructura> getUltimasEstructurasModificadas() {
        return (HashSet<Estructura>) ultimasEstructurasModificadas.clone();
    }
    public void encontrarEstructura(){

    }

    public Estructura recuperarEstructuraFinal(ArrayList<Estructura> estructuras, Casilla casilla) throws Exception {
        for (Estructura estructura : estructuras) {
            if (estructura.getCola().getFirst().getFicha().getId() == casilla.getFicha().getId()) {
                System.out.println("si hay la estructura" + estructura.getClass());
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


