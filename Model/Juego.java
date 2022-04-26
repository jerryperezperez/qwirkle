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
        for (int i = 0; i < this.jugadores.length; i++) {
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
//validarMovimiento() si hay ficha seleccionada
//isPrimerMovimiento()boolean (pone en cualquier lugar permitido)
// else{
// validarexistenciaFichaLateral, validarexistenciFichaSuperior (boolean) }

    public Ficha  sacarFichaBolsa(){
        return this.bolsa.darFicha();
    }
    public boolean reglas1(){//Verifica si tiene una ficha seleccionada el jugador
        if (jugadorEnTurno.getFichaSeleccionada() != null) {

            return true;
        }
        return false;
    }
    public boolean reglas2(int x, int y){//verifica si hay espacio en la casilla para ficha
        //Estoy seguro que esto se puede optimizar en 90%, ya no da tanta pena
        xCas=x;
        yCas=y;
        if (primerTurno){
            getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),x,y);
            return true;
        }
        if (getTablero().casilla[x][y].getFicha() == null){
            System.out.println("regla 2 bien");
            //getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),xCas,yCas);
            return true;
        } else{
            System.out.println("casilla ocupada");
            return false;
        }
    }
    public boolean reglas3(){//verifica la compatibilidad de color y forma con las fichas horizontales y verticales
        if (primerTurno){
            primerTurno=false;
            System.out.println("Salida primer turno");
            return true;
        }
        int contFichasHorizontales = 1;
        int tipoH = 0; //0 no asignado, 1 color, 2 forma
        boolean aplicadaReglaForma =false;
        boolean aplicadaReglaColor = false;
        //HORIZONTAL
        //COLOR
        //IZQUIERDA
        for (int i=0; i<6;i++){
            if (getTablero().casilla[xCas-i][yCas].getFicha() != null){
                System.out.println("Color mi ficha: "+ getJugadorEnTurno().getFichaSeleccionada().getColor());
                System.out.println("Color ficha izq: "+ getTablero().casilla[xCas-i][yCas].getFicha().getColor());
                if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas-i][yCas].getFicha().getColor()){
                    System.out.println("Color igual Izq");
                    contFichasHorizontales++;
                    aplicadaReglaColor = true;
                    tipoH=1;
                }else{
                    System.out.println("Color diferente Izq");
                    if(aplicadaReglaColor){
                        System.out.println("Salida incompatible color y forma");
                        return false;
                    }
                }
            }else if(i!=0){
                i=6;
            }
        }
        if (tipoH==0){
            tipoH=2;
        }
        //DERECHA
        for (int i=0; i<6;i++){
            if (getTablero().casilla[xCas+i][yCas].getFicha() != null){
                System.out.println("Color mi ficha: "+ getJugadorEnTurno().getFichaSeleccionada().getColor());
                System.out.println("Color ficha Der: "+ getTablero().casilla[xCas+i][yCas].getFicha().getColor());
                if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas+i][yCas].getFicha().getColor()){
                    System.out.println("Color igual Der");
                    contFichasHorizontales++;
                    if(contFichasHorizontales>6){
                        System.out.println("Te pasaste de fichas horizontales mi chavo color");
                        return false;
                    }
                    aplicadaReglaColor = true;
                    tipoH=1;
                }else{
                    System.out.println("Color diferente Der");
                    if(aplicadaReglaColor){
                        System.out.println("Salida incompatible color y forma");
                        return false;
                    }
                }
            }else if(i!=0){
                i=6;
            }
        }
        if (tipoH==0){
            tipoH=2;
        }

        //FORMA
        //IZQUIERDA
        for (int i=0; i<6;i++){
            if (getTablero().casilla[xCas-i][yCas].getFicha() != null){//Si la casilla no tiene ficha
                if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas-i][yCas].getFicha().getForma()){
                    System.out.println("Forma igual Izq");
                    System.out.println("tipo: "+tipoH);
                    contFichasHorizontales++;
                    aplicadaReglaForma =true;
                    if (tipoH==1){
                        System.out.println("Salida incompatible color con forma");
                        return false;
                    }
                    tipoH=2;
                }else if (i==5){
                    System.out.println("Salida todo forma");
                    return true;
                }else if (tipoH==2){
                    System.out.println("Forma diferente Izq");
                    return false;
                }
            }else if(tipoH==1){//si es con regla de color
                System.out.println("tipo = "+tipoH);
                System.out.println("Salida regla color 1");
                return true;
            }else if (tipoH==2 && aplicadaReglaForma && aplicadaReglaColor==false){
                System.out.println("Salida regla Forma 1");
                return true;
            }
            else if(i!=0){
                System.out.println("Salida no hay nada");
                return false;
            }
        }
        //DERECHA
        for (int i=0; i<6;i++){
            if (getTablero().casilla[xCas+i][yCas].getFicha() != null){
                if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas+i][yCas].getFicha().getForma()){
                    System.out.println("Forma igual Der");
                    System.out.println("tipo: "+tipoH);
                    contFichasHorizontales++;
                    if(contFichasHorizontales>6){
                        System.out.println("Te pasaste de fichas horizontales mi chavo color");
                        return false;
                    }
                    aplicadaReglaForma =true;
                    if (tipoH==1){
                        System.out.println("Salida incompatible color con forma");
                        return false;
                    }
                    tipoH=2;
                }else if (i==5){
                    System.out.println("Salida todo forma");
                    return true;
                }else if (tipoH==2){
                    System.out.println("Forma diferente Der");
                    return false;
                }
            }else if(tipoH==1){
                System.out.println("tipo = "+tipoH);
                System.out.println("Salida regla color 2");
                return true;
            }else if (tipoH==2 && aplicadaReglaForma && aplicadaReglaColor==false){//detecta que aunque sea de la misma forma, la regla aplicada es de color
                System.out.println("Salida regla Forma 2");
                return true;
            }
            else if(i!=0){
                System.out.println("Salida no hay nada");
                return true;
            }
        }
        System.out.println("Salida final regla 3");
        return true;
    }
    public boolean reglas4(){
                //VERTICAL
                //COLOR
                //ARRIBA
                int contFichasVerticales = 1;
                int tipoV = 0; //0 no asignado, 1 color, 2 forma
                boolean aplicadaReglaForma =false;
                boolean aplicadaReglaColor = false;
                for (int i=0; i<6;i++){
                    if (getTablero().casilla[xCas][yCas-i].getFicha() != null){
                        System.out.println("Color mi ficha: "+ getJugadorEnTurno().getFichaSeleccionada().getColor());
                        System.out.println("Color ficha Arriba: "+ getTablero().casilla[xCas][yCas-i].getFicha().getColor());
                        if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas][yCas-i].getFicha().getColor()){
                            System.out.println("Color igual Arriba");
                            contFichasVerticales++;
                            aplicadaReglaColor = true;
                            tipoV=1;
                        }else{
                            System.out.println("Color diferente Arriba");
                            if(aplicadaReglaColor){
                                System.out.println("Salida incompatible color y forma");
                                return false;
                            }
                        }
                    }else if(i!=0){
                        i=6;
                    }
                }
                if (tipoV==0){
                    tipoV=2;
                }
                //ABAJO
                for (int i=0; i<6;i++){
                    if (getTablero().casilla[xCas][yCas+i].getFicha() != null){
                        System.out.println("Color mi ficha: "+ getJugadorEnTurno().getFichaSeleccionada().getColor());
                        System.out.println("Color ficha Der: "+ getTablero().casilla[xCas][yCas+i].getFicha().getColor());
                        if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas][yCas+i].getFicha().getColor()){
                            System.out.println("Color igual Abajo");
                            contFichasVerticales++;
                            if(contFichasVerticales>6){
                                System.out.println("Te pasaste de fichas Verticales mi chavo color");
                                return false;
                            }
                            aplicadaReglaColor = true;
                            tipoV=1;
                        }else{
                            System.out.println("Color diferente Abajo");
                            if(aplicadaReglaColor){
                                System.out.println("Salida incompatible color y forma");
                                return false;
                            }
                        }
                    }else if(i!=0){
                        i=6;
                    }
                }
                if (tipoV==0){
                    tipoV=2;
                }

                //FORMA
                //ARRIBA
                for (int i=0; i<6;i++){
                    if (getTablero().casilla[xCas][yCas-i].getFicha() != null){//Si la casilla no tiene ficha
                        if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas][yCas-i].getFicha().getForma()){
                            System.out.println("Forma igual Arriba");
                            System.out.println("tipo: "+tipoV);
                            contFichasVerticales++;
                            aplicadaReglaForma =true;
                            if (tipoV==1){
                                System.out.println("Salida incompatible color con forma");
                                return false;
                            }
                            tipoV=2;
                        }else if (contFichasVerticales==5){
                            System.out.println("Salida todo forma");
                            return true;
                        }else if (tipoV==2){
                            System.out.println("Forma diferente Arriba");
                            return false;
                        }
                    }else if(tipoV==1 && aplicadaReglaForma==false){//si es con regla de color
                        System.out.println("tipo = "+tipoV);
                        System.out.println("Salida regla color 3");
                        return true;
                    }else if (tipoV==2 && aplicadaReglaForma && aplicadaReglaColor==false){
                        System.out.println("Salida regla Forma");
                        return true;
                    }
                    else if(i!=0){
                        System.out.println("Salida no hay nada");
                        return false;
                    }
                }
                //ABAJO
                for (int i=0; i<6;i++){
                    if (getTablero().casilla[xCas][yCas+i].getFicha() != null){
                        if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas][yCas+i].getFicha().getForma()){
                            System.out.println("Forma igual Abajo");
                            contFichasVerticales++;
                            if(contFichasVerticales>6){
                                System.out.println("Te pasaste de fichas horizontales mi chavo color");
                                return false;
                            }
                            aplicadaReglaForma =true;
                            if (tipoV==1){
                                System.out.println("Salida incompatible color con forma");
                                return false;
                            }
                            tipoV=2;
                        }else if (i==5){
                            System.out.println("Salida todo forma");
                            return true;
                        }else if (tipoV==2){
                            System.out.println("Forma diferente Abajo");
                            return false;
                        }
                    }else if(tipoV==1 && aplicadaReglaForma==false){
                        System.out.println("tipo = "+tipoV);
                        System.out.println("Salida regla color 4");
                        return true;
                    }else if (tipoV==2 && aplicadaReglaForma && aplicadaReglaColor==false){//detecta que aunque sea de la misma forma, la regla aplicada es de color
                        System.out.println("Salida regla Forma");
                        return true;
                    }
                    else if(i!=0){//esto es para que si no respeta ninguna regla, no te deje poner
                        System.out.println("Salida no hay nada");
                        return false;
                    }
                }

        return false;
    }
    public void asignarRegla(){
        getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),xCas,yCas);
        jugadorEnTurno.removerFicha(jugadorEnTurno.getFichaSeleccionada());
    }
}