package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Bot extends Jugador {
    private ControladorEstructura controladorEstructura;
    private boolean jugadaLista;
    private boolean cambio;
    private Casilla casilla;

    public Bot() {
    }

    public void iniciar(ControladorEstructura controlador) throws Exception {
        System.out.println("SOY EL BOT");
        this.jugadaLista = false;
        this.casilla = null;
        this.controladorEstructura = new ControladorEstructura(controlador);
        this.controladorEstructura.getEstructuraColumnas().sort(new Comparator<Estructura>() {
            @Override
            public int compare(Estructura o1, Estructura o2) {
                return o2.getCola().size() - o1.getCola().size();
            }
        });
        System.out.println(this.getFichaSeleccionada());
        this.formarQwirkle();

      /*  if (this.getFichaSeleccionada() == null){
            System.out.println("VOY A CAMBIAR MI PRIMERA FICHA PORQUE NO HAY QWIRKLE");
            this.cambio = true;
            this.cambiar();
        }*/
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void formarQwirkle() throws Exception {
        for (int i = 5; i > 0; i--) {
            JOptionPane.showMessageDialog(null, "EN ITERACION: " + i);
            if (this.isJugadaEncontradaFilas(i)) {
                JOptionPane.showMessageDialog(null, "HE ENCONTRADO FICHA Y CASILLA");
                break;
            } else {
                if (this.isJugadaEncontradaColumnas(i)) {
                    JOptionPane.showMessageDialog(null, "HE ENCONTRADO FICHA Y CASILLA");
                    break;
                }
            }
        }
    }

    public boolean isJugadaEncontradaFilas(int i) throws Exception {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            if (fila.getCola().size() == i) {
                System.out.println("HAY COLAAAAA");
                for (Ficha ficha : this.getArregloFichas()) {
                    if (Regla.cumpleRestriccion(fila, ficha)) {
                        if (fila.getCola().getLast().getCasillaDerecha() != null) {
                            try {
                                System.out.println("entra en try de fila");
                                this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                                this.setFichaSeleccionada(ficha);
                                fila.getCola().getLast().setFicha(null);
                                this.casilla = fila.getCola().getLast();
                                System.out.println("YA HE ELEGIDO MI JUGADA");
                                this.cambio = false;
                                return true;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "NO HE PODIDO AGREGAR, SALTO ESTE TRY");

                                e.printStackTrace();
                            }
                        } else {
                            if (fila.getCola().getFirst().getCasillaIzquierda() != null) {
                                try {
                                    System.out.println("entra en try de fila");
                                    this.controladorEstructura.agregar(fila.getCola().getFirst().getCasillaIzquierda(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    System.out.println("YA HE ELEGIDO MI JUGADA");
                                    fila.getCola().getFirst().setFicha(null);
                                    this.casilla = fila.getCola().getFirst();
                                    this.casilla.setFicha(null);
                                    this.cambio = false;
                                    return true;
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "NO HE PODIDO AGREGAR, SALTO ESTE TRY");

                                    e.printStackTrace();
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
                                System.out.println("entra en try de columna");
                                this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                                this.setFichaSeleccionada(ficha);
                                this.cambio = false;
                                System.out.println("YA HE ELEGIDO MI JUGADA");
                                columna.getCola().getLast().setFicha(null);
                                this.casilla = columna.getCola().getLast();
                                this.casilla.setFicha(null);
                                return true;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "NO HE PODIDO AGREGAR, SALTO ESTE TRY");
                                e.printStackTrace();
                            }
                        } else {
                            if (columna.getCola().getFirst().getCasillaSuperior() != null) {
                                try {
                                    System.out.println("entra en try de columna");
                                    this.controladorEstructura.agregar(columna.getCola().getFirst().getCasillaSuperior(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    System.out.println("YA HE ELEGIDO MI JUGADA");
                                    columna.getCola().getFirst().setFicha(null);
                                    this.casilla = columna.getCola().getFirst();
                                    this.casilla.setFicha(null);
                                    this.cambio = false;
                                    return true;
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "NO HE PODIDO AGREGAR, SALTO ESTE TRY");

                                    e.printStackTrace();
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
