package Model;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.swing.*;

public class Juego {

    private Bolsa bolsa;
    private Tablero tablero;
    private ControladorEstructura controladorEstructura;
    private Casilla ultimaJugada;
    private String direccion;
    private int numeroJugadorEnTurno = 0; //apunta un jugador adelante. Posible cambio a proximoNumeroJugadorEnTurno
    public Jugador jugadores[];

    boolean primerMovimiento = true;

    public Juego(int cantidadJugadores) {//agregar como parámetro la cantidad de jugadores, esándar es de dos, a lo mejor se agregan otros
        this.bolsa = new Bolsa();
        this.tablero = new Tablero();
        // this.estructura = new Estructura();
        this.jugadores = new Jugador[cantidadJugadores];
        // this.regla = new Regla(this.bolsa, this.tablero);

//creador de jugadores. TODO para crear métodos instanciadores como crearJugadores
        for (int i = 0; i < jugadores.length-1; i++) {
            jugadores[i] = new Jugador();
        }
        this.jugadores[this.jugadores.length-1] = new Bot();

        this.asignarFichas();
    }
//Posible creación del método iniciar para evitar mucho código en el constructor

    public void iniciarJuego() {
    }



    public void asignarFichas() {
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

    public void intercambiarFicha() {
        jugadores[1].getArregloFichas();
        Ficha fichaDeCambio = jugadores[1].devolverFicha();
        jugadores[1].setFicha(bolsa.intercambiarFicha(fichaDeCambio));
        jugadores[1].getArregloFichas();
    }

    public Ficha sacarFichaBolsa() {
        return this.bolsa.darFicha();
    }

    public boolean isMovimientoValido(Casilla casilla) throws Exception {
        if (this.primerMovimiento) {
            this.realizarPrimerMovimiento(casilla);
        } else {
            if (casilla.getFicha() != null) {
                throw new Exception("ESTA CASILLA YA TIENE FICHA");
            }
            if (!casilla.hayFichaAdyacente()) {
                throw new Exception("NO HAY FICHA ADYACENTE");
            }
            if (this.ultimaJugada != null) { // concatenar if anidado con &&
                this.ultimaJugada.verificarCasillaAdyacente(casilla);
                if (this.direccion != null) {
                    if (!this.ultimaJugada.esMismaLinea(casilla, this.direccion)) {
                        throw new Exception("NO ES EL MISMO VECTOR");
                    }
                }
            }
            this.getJugadorEnTurno().sumarPuntos(this.controladorEstructura.agregar(casilla, this.jugadores[numeroJugadorEnTurno].getFichaSeleccionada()));
                this.realizarMovimiento(casilla);
        }
        return true;
    }

    public void definirDireccion(Casilla casilla) {
        if (!this.ultimaJugada.equals(casilla)) {
            if (this.ultimaJugada.getX() == casilla.getX()) {
                this.direccion = "COLUMNA";
            } else {
                if (this.ultimaJugada.getY() == casilla.getY()) {
                    this.direccion = "FILA";
                }
            }
        }
    }

    public void realizarPrimerMovimiento(Casilla casilla) {
        this.controladorEstructura = new ControladorEstructura(casilla);
        this.realizarMovimiento(casilla);
        this.primerMovimiento = false;
    }

    private void realizarMovimiento(Casilla casilla) {
        if (this.direccion == null) {
            if (this.ultimaJugada != null) {
                this.definirDireccion(casilla);
            }
        }
        this.ultimaJugada = casilla;
        this.tablero.casilla[casilla.getX()][casilla.getY()].setFicha(this.jugadores[numeroJugadorEnTurno].getFichaSeleccionada());
        //this.controladorEstructura.imprimirEstructuras();
    }

    public void terminarTurno() {
        this.getJugadorEnTurno().removerFichaSeleccionada();
        this.getJugadorEnTurno().quitarFichasJugadas();
        while (this.getJugadorEnTurno().getArregloFichas().length < 6) {
            this.getJugadorEnTurno().setFicha(this.sacarFichaBolsa());
        }
        this.ultimaJugada = null;
        this.direccion = null;
        this.cambiarJugador();
    }

    public void cambiarJugador() {
        if (this.numeroJugadorEnTurno == this.jugadores.length - 1) {
            this.numeroJugadorEnTurno = 0;
        } else {
            this.numeroJugadorEnTurno++;
        }
        if (this.jugadores[numeroJugadorEnTurno] instanceof Bot){
            ((Bot)this.jugadores[numeroJugadorEnTurno]).iniciar(this.controladorEstructura.getEstructuraFilas(), this.controladorEstructura.getEstructuraColumnas());
        }
    }

    public int getNumeroJugadorEnTurno() {
        return numeroJugadorEnTurno;
    }
}