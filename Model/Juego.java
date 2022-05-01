package Model;

public class Juego {

    private Bolsa bolsa;
    private Tablero tablero;
    private ControladorEstructura controladorEstructura;
    private Jugador jugadorEnTurno;
    private Casilla ultimaJugada;
    private Regla regla;
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
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador();
        }
        this.asignarFichas();
        this.asignarTurno();


    }
//Posible creación del método iniciar para evitar mucho código en el constructor

    public void iniciarJuego() {
    }

    public void asignarTurno() {
        this.jugadorEnTurno = this.jugadores[this.numeroJugadorEnTurno];
        if (this.numeroJugadorEnTurno == 4) {
            this.numeroJugadorEnTurno = 0;
        } else {
            this.numeroJugadorEnTurno += 1;
        }
    }

    public void asignarFichas() {
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < 6; j++) {
                jugadores[i].setFicha(this.bolsa.darFicha());
            }
        }
    }

    public Jugador getJugadorEnTurno() {
        return this.jugadorEnTurno;
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
            if (casilla.findCasilla(this.ultimaJugada)) {
                if (this.controladorEstructura.agregar(casilla, this.jugadorEnTurno.getFichaSeleccionada())) {
                    this.realizarMovimiento(casilla);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


    public void realizarPrimerMovimiento(Casilla casilla) {
        this.controladorEstructura = new ControladorEstructura(casilla);
        this.realizarMovimiento(casilla);
        this.primerMovimiento = false;
    }

    private void realizarMovimiento(Casilla casilla) {
        this.ultimaJugada = casilla;
        this.tablero.casilla[casilla.getX()][casilla.getY()].setFicha(this.jugadorEnTurno.getFichaSeleccionada());
        this.controladorEstructura.imprimirEstructuras();

    }

}