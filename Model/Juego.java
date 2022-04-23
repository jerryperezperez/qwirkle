package Model;

public class Juego {

    Bolsa bolsa;
    Tablero tablero;

    private Jugador jugadorEnTurno;
    private int numeroJugadorEnTurno = 0; //apunta un jugador adelante. Posible cambio a proximoNumeroJugadorEnTurno
    public Jugador jugadores[];
    boolean primerTurno=true;
    int xCas;
    int yCas;
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
        //System.out.println("CANTIDA DE JUGADORES " + jugadores.length);
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < 6; j++) {
                jugadores[i].setFicha(this.bolsa.darFicha());
            }
        }
    }

    public Jugador getJugadorEnTurno(){
        return this.jugadorEnTurno;
    }
    public Tablero getTablero(){
        return this.tablero;
    }
    public void intercambiarFicha () {
        jugadores[1].getArregloFichas();
        Ficha fichaDeCambio = jugadores[1].devolverFicha();
        jugadores[1].setFicha(bolsa.intercambiarFicha(fichaDeCambio));
        jugadores[1].getArregloFichas();
    }

    public Ficha  sacarFichaBolsa(){
        return this.bolsa.darFicha();
    }
    public boolean reglas1(String evento){
        //Estoy seguro que esto se puede optimizar en 9000%, ni lo vean que da pena
        //Regla para verificar si hay espacio para ficha
        String num;
        String aux ="";
        boolean isNumeric;
        boolean vuelta =true;
        for (int i=21; i<26; i++){
            num = evento.charAt(i)+"";
            isNumeric =  num.matches("[+-]?\\d*(\\.\\d+)?");
            //System.out.println("es numero? "+ isNumeric + " abr: "+num);
            if (isNumeric){
                aux = aux+num;
            } else if (vuelta){
                xCas = Integer.parseInt(aux);
                aux="";
                //System.out.println("Veamos xCas: "+xCas);
                vuelta = false;
            } else {
                yCas =Integer.parseInt(aux);
                //System.out.println("Veamos yCas: "+yCas);
            }
        }
        if (primerTurno){
            getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),xCas,yCas);
            return true;
        }
        if (getTablero().casilla[xCas][yCas].getFicha() == null){
            System.out.println("Primera regla bien");
            //getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),xCas,yCas);
            return true;
        } else{
            System.out.println("casilla ocupada");
            return false;
        }
    }
    public boolean reglas2(){
        if (primerTurno){
            primerTurno=false;
            System.out.println("Salida primer turno");
            return true;
        }
        int contFichasHorizontales = 1;
        int contFichasVerticales = 1;
        int tipo = 0; //0 no asignado, 1 color, 2 forma
        boolean aplicadaRegla=false;
        //COLOR
        for (int i=0; i<6;i++){ //izquierda
            if (getTablero().casilla[xCas-i][yCas].getFicha() != null){
                System.out.println("Color mi ficha: "+ getJugadorEnTurno().getFichaSeleccionada().getColor());
                System.out.println("Color ficha izq: "+ getTablero().casilla[xCas-i][yCas].getFicha().getColor());
                if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas-i][yCas].getFicha().getColor()){
                    System.out.println("Color igual Izq");
                    contFichasHorizontales++;
                    tipo=1;
                }else{
                    System.out.println("Color diferente Izq");
                    i=6;
                }
            }else if(i!=0){
                i=6;
            }
        }
        if (tipo==0){
            tipo=2;
        }


        //FORMA
        for (int i=0; i<6;i++){ //izquierda

            if (getTablero().casilla[xCas-i][yCas].getFicha() != null){
                if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas-i][yCas].getFicha().getForma()){
                    System.out.println("Forma igual Izq");
                    System.out.println("tipo: "+tipo);
                    aplicadaRegla=true;
                    if (tipo==1){
                        System.out.println("Salida incompatible color con forma");
                        return false;
                    }
                    contFichasHorizontales++;
                    tipo=2;
                }else if (i==5){
                    System.out.println("Salida todo forma");
                    return true;
                }else if (tipo==2){
                    System.out.println("Forma diferente Izq");
                    return false;
                }
            }else if(tipo==1){
                System.out.println("tipo = "+tipo);
                System.out.println("Salida regla color");
                return true;
            }else if (tipo==2 && aplicadaRegla){
                System.out.println("Salida regla Forma");
                return true;
            }
            else if(i!=0){
                System.out.println("Salida no hay nada");
                return false;
            }
        }
        System.out.println("Salida final");
        return false;
    }
    public boolean reglas3(){

        return false;
    }
    public void asignarRegla(){
        getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),xCas,yCas);
    }
}