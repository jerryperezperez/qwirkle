package Model;

public class Juego {

    Bolsa bolsa;
    Tablero tablero;

    private Jugador jugadorEnTurno;
    private int numeroJugadorEnTurno = 0; //apunta un jugador adelante. Posible cambio a proximoNumeroJugadorEnTurno
    public Jugador jugadores[];
    Ficha ficha;

    public Juego(int cantidadJugadores) {//agregar como parámetro la cantidad de jugadores, esándar es de dos, a lo mejor se agregan otros
        this.bolsa = new Bolsa();
        this.tablero = new Tablero();
        jugadores = new Jugador[cantidadJugadores];

//creador de jugadores. Podría modificarse todo para crear métodos instanciadores como crearJugadores
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador();
        }
        this.asignarFichas();
        this.asignarTurno();


        }
//Posible creación del método iniciar para evitar mucho código en el constructor

        public void iniciarJuego () {
        }

        public  void asignarTurno(){
            this.jugadorEnTurno = this.jugadores[this.numeroJugadorEnTurno];
            if(this.numeroJugadorEnTurno == 4){
                this.numeroJugadorEnTurno = 0;
            }else{
                this.numeroJugadorEnTurno += 1;

            }

        }

        public void asignarFichas () {
            System.out.println("CANTIDA DE JUGADORES " + jugadores.length);
            for (int i = 0; i < jugadores.length; i++) {
                for (int j = 0; j < 6; j++) {
                    jugadores[i].setFicha(this.bolsa.darFicha());
                }
            }
        }

        public Jugador getJugadorEnTurno(){
        return this.jugadorEnTurno;
        }

        public void intercambiarFicha () {
            jugadores[1].getFichas();
            Ficha fichaDeCambio = jugadores[1].devolverFicha();
            jugadores[1].setFicha(bolsa.intercambiarFicha(fichaDeCambio));
            jugadores[1].getFichas();
        }

        public Ficha  sacarFichaBolsa(){
            return this.bolsa.darFicha();
        }
        public void ponerFicha(){
            Ficha fichaSeleccionada = jugadores[1].devolverFicha(); //esta es la ficha que se clica para poner
            tablero.ponerFicha(fichaSeleccionada); //llama al metodo para agragarla al tablero
            jugadores[1].setFicha(bolsa.intercambiarFicha(fichaSeleccionada)); 
            
        }
 
    }
