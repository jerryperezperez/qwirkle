package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Bot extends Jugador {
    private ControladorEstructura controladorEstructura;
    private boolean jugadaLista;
    private boolean cambio;
    private Casilla casilla;
    private ArrayList<Nodo> arregloNodos;
    Algoritmo algoritmo;

    public Bot() {
        arregloNodos = new ArrayList<>();
    }

    public void iniciar(ControladorEstructura controlador) throws Exception {
        // this.jugadaLista = false;
        this.casilla = null;
        this.controladorEstructura = new ControladorEstructura(controlador);
        this.controladorEstructura.getEstructuraColumnas().sort(new Comparator<Estructura>() {
            @Override
            public int compare(Estructura o1, Estructura o2) {
                return o2.getCola().size() - o1.getCola().size();
            }
        });
        this.formarQwirkle();
    /*    if (casilla == null && this.arregloNodos.isEmpty()) {
            Nodo nodo = new Nodo(this.controladorEstructura, this.getFichas2());
            Algoritmo algoritmo = new Algoritmo(nodo);
            this.arregloNodos.addAll(algoritmo.mejorRuta);
        }
        if (this.arregloNodos.isEmpty()) {
            this.casilla = null;
        } else {
            Thread.sleep(3000);
            this.setFichaSeleccionada(this.arregloNodos.get(0).fichaBot);
            this.casilla = this.arregloNodos.get(0).casillaBot;
            this.arregloNodos.remove(0);
        }*/

    }

    public Casilla getCasilla() {
        return casilla;
    }


    public void formarQwirkle() throws Exception {
        for (int i = 5; i > 0; i--) {
            if (this.isJugadaEncontradaFilas(i)) {
                JOptionPane.showMessageDialog(null, "HE ENCONTRADO FICHA Y CASILLA");
            } else {
                if (this.isJugadaEncontradaColumnas(i)) {
                    JOptionPane.showMessageDialog(null, "HE ENCONTRADO FICHA Y CASILLA");
                }
            }
        }
    }

    public boolean isJugadaEncontradaFilas(int i) throws Exception {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            if (fila.getCola().size() == i) {
                for (Ficha ficha : this.getArregloFichas()) {
                    if (Regla.cumpleRestriccion(fila, ficha)) {
                        if (fila.getCola().getLast().getCasillaDerecha() != null) {
                            try {
                                this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                                this.setFichaSeleccionada(ficha);
                                fila.getCola().getLast().setFicha(null);
                                this.casilla = fila.getCola().getLast();
                                this.cambio = false;
                                return true;
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        } else {
                            if (fila.getCola().getFirst().getCasillaIzquierda() != null) {
                                try {
                                    this.controladorEstructura.agregar(fila.getCola().getFirst().getCasillaIzquierda(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    fila.getCola().getFirst().setFicha(null);
                                    this.casilla = fila.getCola().getFirst();
                                    this.casilla.setFicha(null);
                                    this.cambio = false;
                                    return true;
                                } catch (Exception e) {
                                    e.getMessage();
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isJugadaEncontradaColumnas(int i) throws Exception {
        for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
            if (columna.getCola().size() == i) {
                for (Ficha ficha : this.getArregloFichas()) {
                    if (Regla.cumpleRestriccion(columna, ficha)) {
                        if (columna.getCola().getLast().getCasillaInferior() != null) {
                            try {
                                this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                                this.setFichaSeleccionada(ficha);
                                this.cambio = false;
                                columna.getCola().getLast().setFicha(null);
                                this.casilla = columna.getCola().getLast();
                                this.casilla.setFicha(null);
                                return true;
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        } else {
                            if (columna.getCola().getFirst().getCasillaSuperior() != null) {
                                try {
                                    this.controladorEstructura.agregar(columna.getCola().getFirst().getCasillaSuperior(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    columna.getCola().getFirst().setFicha(null);
                                    this.casilla = columna.getCola().getFirst();
                                    this.casilla.setFicha(null);
                                    this.cambio = false;
                                    return true;
                                } catch (Exception e) {
                                    e.getMessage();
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
