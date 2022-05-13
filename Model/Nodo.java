package Model;

import java.util.ArrayList;

public class Nodo extends Jugador {
    private ArrayList<Nodo> nodosApuntados;
    private ControladorEstructura controlador;
    public Casilla casillaBot;
    public Ficha fichaBot;
    public ArrayList<Ficha> fichasJugador;

    public Nodo(ControladorEstructura controlador, ArrayList<Ficha> fichas) {
        this.controlador = new ControladorEstructura(controlador);
        this.nodosApuntados = new ArrayList<Nodo>();
        this.fichasJugador = new ArrayList<Ficha>();
        this.fichasJugador.addAll(fichas);
        this.getNodos();
    }

    public Nodo(ControladorEstructura controlador, Casilla casilla, Ficha ficha, ArrayList<Ficha> fichas) {
        this.controlador = new ControladorEstructura(controlador);
        this.casillaBot = new Casilla(casilla);
        this.nodosApuntados = new ArrayList<Nodo>();
        this.fichasJugador = new ArrayList<Ficha>();
        this.fichasJugador.addAll(fichas);
        this.fichaBot = ficha;
        this.getNodos();
    }

    public ArrayList<Nodo> getNodosApuntados() {
        return nodosApuntados;
    }

    public ControladorEstructura getControlador() {
        return controlador;
    }


    public Casilla getCasillaBot() {
        return casillaBot;
    }

    public Ficha getFichaBot() {
        return fichaBot;
    }

    public int cantidadFichasAfecadas() {
        int cantidad = 0;
        for (Estructura estructura : this.controlador.getUltimasEstructurasModificadas()) {
            cantidad = cantidad + estructura.getCola().size();
        }
        return cantidad;
    }


    public void getNodos() {
        for (Ficha ficha : this.fichasJugador) {
            //RECORRER CADA FICHA POR CADA FILA POR IZQUIERDA Y DERECHA
            for (Estructura estructuraFila : this.controlador.getEstructuraFilas()) {
                ControladorEstructura controladorAuxiliar = new ControladorEstructura(controlador);
                try {
                    controladorAuxiliar.agregar(estructuraFila.getCola().getFirst().getCasillaIzquierda(), ficha);
                    nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraFila.getCola().getFirst().getCasillaIzquierda(), ficha, this.fichas));
                    System.out.println("HA AGREGADOOOOO");

                } catch (Exception e) {
                    System.out.println("NO HA PODIDO AGREGAR AQUÍ");
                }
                controladorAuxiliar = new ControladorEstructura(controlador);
                try {
                    controladorAuxiliar.agregar(estructuraFila.getCola().getLast().getCasillaDerecha(), ficha);
                    nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraFila.getCola().getLast().getCasillaDerecha(), ficha, fichas));
                    System.out.println("HA AGREGADOOOOO");
                } catch (Exception e) {
                    System.out.println("NO HA PODIDO AGREGAR AQUÍ");
                }
            }
            //RECORRER CADA FICHA POR CADA COLUMNA POR ARRIBA Y ABAJO
            for (Estructura estructuraColumna : this.controlador.getEstructuraColumnas()) {
                ControladorEstructura controladorAuxiliar = new ControladorEstructura(controlador);
                try {
                    controladorAuxiliar.agregar(estructuraColumna.getCola().getFirst().getCasillaSuperior(), ficha);
                    nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraColumna.getCola().getFirst().getCasillaSuperior(), ficha, fichas));
                    System.out.println("HA AGREGADOOOOO");
                } catch (Exception e) {
                    System.out.println("NO HA PODIDO AGREGAR AQUÍ");

                }
                try {
                    controladorAuxiliar.agregar(estructuraColumna.getCola().getLast().getCasillaInferior(), ficha);
                    nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraColumna.getCola().getLast().getCasillaInferior(), ficha, fichas));
                    System.out.println("HA AGREGADOOOOO");
                } catch (Exception e) {
                    System.out.println("NO HA PODIDO AGREGAR AQUÍ");

                }
            }
        }

    }
}
