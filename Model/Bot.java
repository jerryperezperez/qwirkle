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
        JOptionPane.showMessageDialog(null, casilla.toString() + " y " + this.getFichaSeleccionada());
        return casilla;
    }

    public void formarQwirkle() throws Exception {
        for (int i = 5; i > 0 ; i--) {
            JOptionPane.showMessageDialog(null, "EN ITERACION: " + i);
           if (this.isJugadaEncontradaFilas(i)){
               return;
           }else{
               if (this.isJugadaEncontradaColumnas(i)){
                   return;
               }
           }
        }
    }

    public boolean isJugadaEncontradaFilas(int i) throws Exception {
        for (Estructura fila: this.controladorEstructura.getEstructuraFilas()) {
            if (fila.getCola().size() ==i){
                for (Ficha ficha: this.getArregloFichas()) {
                    if (Regla.cumpleRestriccion(fila,ficha)){
                        if (fila.getCola().getLast().getCasillaDerecha() != null){
                            try {
                                this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                                this.setFichaSeleccionada(ficha);
                                this.casilla = fila.getCola().getLast().getCasillaDerecha();
                                System.out.println("YA HE ELEGIDO MI JUGADA");
                                this.cambio = false;
                                break;
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        }else{
                            if (fila.getCola().getFirst().getCasillaIzquierda() != null){
                                try{
                                    this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaIzquierda(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    System.out.println("YA HE ELEGIDO MI JUGADA");
                                    this.casilla = fila.getCola().getLast().getCasillaIzquierda();
                                    this.cambio = false;
                                    break;
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
        for (Estructura columna: this.controladorEstructura.getEstructuraColumnas()) {
            if (columna.getCola().size() ==i){
                for (Ficha ficha: this.getArregloFichas()) {
                    System.out.println("PRUEBA CON FICHA " + ficha.toString());
                    if (Regla.cumpleRestriccion(columna,ficha)){
                        if (columna.getCola().getLast().getCasillaInferior() != null){
                            try {
                                this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                                this.setFichaSeleccionada(ficha);
                                this.cambio = false;
                                System.out.println("YA HE ELEGIDO MI JUGADA");
                                this.casilla = columna.getCola().getLast().getCasillaInferior();
                                return true;
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        }else{
                            if (columna.getCola().getFirst().getCasillaSuperior() != null){
                                try{
                                    this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaSuperior(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    System.out.println("YA HE ELEGIDO MI JUGADA");
                                    this.casilla = columna.getCola().getLast().getCasillaSuperior();
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
