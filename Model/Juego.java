package Model;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

public class Juego {

    private Bolsa bolsa;
    private Tablero tablero;
    private ControladorEstructura controladorEstructura;
    private Casilla ultimaJugada;
    private String direccion;
    private ArrayList<Ficha> fichasTramitadas;
    private boolean fichaEncambio;
    private int numeroJugadorEnTurno = 0; //apunta un jugador adelante. Posible cambio a proximoNumeroJugadorEnTurno
    public Jugador jugadores[];

    boolean primerMovimiento = true;

    public Juego(ArrayList<String> listaJugadores) throws Exception {//agregar como parámetro la cantidad de jugadores, esándar es de dos, a lo mejor se agregan otros
        this.bolsa = new Bolsa();
        this.tablero = new Tablero();
        // this.estructura = new Estructura();
        this.jugadores = new Jugador[listaJugadores.size()];
        this.fichaEncambio = false;
        this.fichasTramitadas = new ArrayList<Ficha>();
        // this.regla = new Regla(this.bolsa, this.tablero);

//creador de jugadores. TODO para crear métodos instanciadores como crearJugadores

        this.crearJugadores(listaJugadores);
        /*for (int i = 0; i < jugadores.length - 1; i++) {
            jugadores[i] = new Jugador();
        }*/
        // this.jugadores[this.jugadores.length - 1] = new Bot();

        this.asignarFichas();
       /* for (Ficha ficha : this.jugadores[this.jugadores.length - 1].getArregloFichas()) {
            System.out.println(ficha.toString());
        }*/
    }

    private void crearJugadores(ArrayList<String> listaJugadores) {
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(listaJugadores.get(i));
            switch (listaJugadores.get(i)) {
                case "Jugador Humano":
                    System.out.println("ENTRA A  CREAR JUGADOR");
                    this.jugadores[i] = new Jugador();
                    break;
                case "Bot Equipo 5":
                    System.out.println("ENTRA A  CREAR JUGADOR");
                    this.jugadores[i] = new BotEquipo5();
                    break;
                case "BotEquipo6":
                    break;
                case "BotEquipo7":
                    break;
                case "BotEquipo5Avanzado":
                    break;
            }
        }
    }

    public void setUltimaJugada(Casilla ultimaJugada) {
        this.ultimaJugada = ultimaJugada;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarFichaCambio(Ficha ficha) {
        this.fichasTramitadas.add(ficha);
    }

    public boolean isFichaEncambio() {
        return fichaEncambio;
    }

    public void setFichaEncambio(boolean fichaEncambio) {
        this.fichaEncambio = fichaEncambio;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public ControladorEstructura getControladorEstructura() {
        return controladorEstructura;
    }
    //Posible creación del método iniciar para evitar mucho código en el constructor

    public void iniciarJuego() {
    }


    public void asignarFichas() throws Exception {
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < 6; j++) {
                jugadores[i].setFicha(this.bolsa.darFicha());
            }
        }
    }

    public Jugador getJugadorEnTurno() {
        return this.jugadores[this.numeroJugadorEnTurno];
    }

    public Tablero getTablero() {
        return this.tablero;
    }


    public Ficha sacarFichaBolsa() throws Exception {
        return this.bolsa.darFicha();
    }

    public boolean isMovimientoValido(Casilla casilla) throws Exception {

        if (this.primerMovimiento) {
            this.realizarPrimerMovimiento(casilla);
        } else {
            if (casilla.getFicha() != null) {
                throw new Exception("ESTA CASILLA YA TIENE FICHA");
            }
       /*     if (!casilla.hayFichaAdyacente()) {
                throw new Exception("NO HAY FICHA ADYACENTE");
            }
            if (this.ultimaJugada != null) { // concatenar if anidado con &&
                this.ultimaJugada.verificarCasillaAdyacente(casilla);
                if (this.direccion != null) {
                    if (!this.ultimaJugada.esMismaLinea(casilla, this.direccion)) {
                        throw new Exception("NO ES EL MISMO VECTOR");
                    }
                }
            }*/
            this.controladorEstructura.agregar(casilla, this.jugadores[numeroJugadorEnTurno].getFichaSeleccionada());
            this.realizarMovimiento(casilla);
            // ESTO ESTÁ IGUAL EN EL CONTROLLER, SE DEBE ESTAR DUPLICANDO PERO NO DEBERÍA AFECTAR LA INTERACIÓN DEL JUEGO
            //SE DUPLICA AQUÍ PARA PROBAR CON LA FUNCIONALIDAD DEL BOT
            if (this.getJugadorEnTurno() instanceof Bot) {
                this.getJugadorEnTurno().removerFicha(this.getJugadorEnTurno().getFichaSeleccionada());
                this.getJugadorEnTurno().setFichaSeleccionada(null);
            }

        }
        return true;
    }

    /*public void definirDireccion(Casilla casilla) {
        if (!this.ultimaJugada.equals(casilla)) {
            if (this.ultimaJugada.getX() == casilla.getX()) {
                this.direccion = "COLUMNA";
            } else {
                if (this.ultimaJugada.getY() == casilla.getY()) {
                    this.direccion = "FILA";
                }
            }
        }
    }*/

    public void realizarPrimerMovimiento(Casilla casilla) {
        this.controladorEstructura = new ControladorEstructura(casilla);
        this.realizarMovimiento(casilla);
        this.primerMovimiento = false;
    }

    private void realizarMovimiento(Casilla casilla) {
        /*if (this.direccion == null) {
            if (this.ultimaJugada != null) {
                this.definirDireccion(casilla);
            }
        }*/
        this.ultimaJugada = casilla;
        this.tablero.casilla[casilla.getX()][casilla.getY()].setFicha(this.jugadores[numeroJugadorEnTurno].getFichaSeleccionada());
        //   this.controladorEstructura.imprimirEstructuras();
    }

    public int calcularPuntos(HashSet<Estructura> estructuras) {
        int puntos = 0;
        for (Estructura estructura : estructuras) {
            puntos = puntos + estructura.getCola().size();
            if (estructura.getCola().size() == 6) {
                puntos += 6;
            }
        }
        return puntos;
    }

    public void terminarJuego() {

    }

    public void terminarTurno() throws Exception {
        this.getJugadorEnTurno().removerFichaSeleccionada();
        this.getJugadorEnTurno().quitarFichasJugadas();
       /* for (Estructura estructura: this.controladorEstructura.getUltimasEstructurasModificadas()) {
            System.out.println(estructura.toString());
        }*/
        //this.controladorEstructura.imprimirEstructuras();
        if (this.fichaEncambio == true) {
            if (!this.fichasTramitadas.isEmpty()) {
                for (Ficha ficha : this.fichasTramitadas) {
                    this.bolsa.recibirFicha(ficha);
                }
            }
        } else {
            this.jugadores[this.numeroJugadorEnTurno].sumarPuntos(this.calcularPuntos(this.controladorEstructura.getUltimasEstructurasModificadas()));
            JOptionPane.showMessageDialog(null, "PUNTOS GANADOS: " + this.calcularPuntos(this.controladorEstructura.getUltimasEstructurasModificadas()));

        }
        this.limpiarControladorEstructura();
        while ((this.getJugadorEnTurno().getArregloFichas().length < 6) && (!this.bolsa.fichas.isEmpty())) {
            this.getJugadorEnTurno().setFicha(this.sacarFichaBolsa());
        }
        this.cambiarJugador();
        this.fichaEncambio = false;
    }

    public void limpiarControladorEstructura() {
        this.controladorEstructura.limpiarUltimasEstructurasModificadas();
        this.controladorEstructura.setUltimaJugada(null);
        this.controladorEstructura.setDireccion(null);
    }

    public void cambiarJugador() {
        if (this.numeroJugadorEnTurno == this.jugadores.length - 1) {
            this.numeroJugadorEnTurno = 0;
        } else {
            this.numeroJugadorEnTurno++;
        }
    }

    public void moverBot(int iterador) throws Exception {
        this.jugadores[numeroJugadorEnTurno].setFichaSeleccionada(null);
        //System.out.println("LA ULTIMA JUGADA ES: " + this.controladorEstructura.getUltimaJugada().toString());
        if (this.controladorEstructura == null){
            ((Bot) this.jugadores[numeroJugadorEnTurno]).iniciarPartida();
           ((Bot) this.jugadores[numeroJugadorEnTurno]).setCasilla(this.tablero.casilla[10][10]);
        }else{
            ((Bot) this.jugadores[numeroJugadorEnTurno]).iniciar((ControladorEstructura) this.controladorEstructura.clone(), iterador);
        }
        if (((Bot) this.jugadores[numeroJugadorEnTurno]).getCasilla() != null) {
            // this.controladorEstructura.imprimirEstructuras();
            this.isMovimientoValido(((Bot) this.jugadores[numeroJugadorEnTurno]).getCasilla());

        }
    }

    public int getNumeroJugadorEnTurno() {
        return numeroJugadorEnTurno;
    }
}