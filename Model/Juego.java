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

    public boolean reglas0(){
        if (primerTurno){
            primerTurno=false;
            System.out.println("Salida primer turno");
            return true;
        }
        return false;
    }

    public boolean reglas1(){//Verifica si tiene una ficha seleccionada el jugador
        if (jugadorEnTurno.getFichaSeleccionada() != null) {
            return true;
        }
        return false;
    }

    public boolean reglas2(int x, int y){//verifica si hay espacio en la casilla para ficha
        if (getTablero().casilla[x][y].getFicha() == null){
            xCas=x;
            yCas=y;
            //getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),xCas,yCas);
            return true;
        } else{
            System.out.println("casilla ocupada");
            return false;
        }
    }
    //HORIZONTAL COLOR
    public boolean reglas3(){//verifica la compatibilidad de color y forma con las fichas horizontales y verticales
        int contFichasHorizontales = 1;
        boolean aplicadaReglaColorIzq =false;
        boolean aplicadaReglaColorDer = false;
        //HORIZONTAL
        //COLOR
        //IZQUIERDA
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas-i][yCas].getFicha() != null){//Si hay ficha en casilla
                if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas-i][yCas].getFicha().getColor() &&getJugadorEnTurno().getFichaSeleccionada().getForma()!=getTablero().casilla[xCas-i][yCas].getFicha().getForma()){//si el color de tu ficha es igual al de la izquierda
                    contFichasHorizontales++;
                    aplicadaReglaColorIzq = true;
                }else{//si no, entonces no aplica regla color por la izquierda
                    aplicadaReglaColorIzq=false;
                    break;
                }
            }else if(i!=1){//salida para cuando recorre todas las fichas puestas a la izquierda
                break;
            }else if(i==1){
                System.out.println("No hay fichas izquierda");
                aplicadaReglaColorIzq = true;
                break;
            }
        }
        //DERECHA
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas+i][yCas].getFicha() != null){
                if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas+i][yCas].getFicha().getColor()&&getJugadorEnTurno().getFichaSeleccionada().getForma()!=getTablero().casilla[xCas+i][yCas].getFicha().getForma()){
                    contFichasHorizontales++;
                    aplicadaReglaColorDer = true;
                    System.out.println("Se aplica true por color igual");
                    if(contFichasHorizontales>6){
                        System.out.println("Te pasaste de fichas HORIZONTALES mi chavo COLOR");
                        return false;
                    }
                }else{
                    System.out.println("false porque no hay mismo color");
                    aplicadaReglaColorDer = false;
                    break;
                }
            }else if(i!=1){
                System.out.println("Encontró casilla vacía "+i);
                break;
            }else if(i==1){
                System.out.println("No hay fichas derecha");
                aplicadaReglaColorDer = true;
                break;
            }
        }
        if (aplicadaReglaColorDer==false || aplicadaReglaColorIzq==false){
            System.out.println("Salida mal regla 3");
            return false;
        }
        System.out.println("Salida bien regla 3");
        return true;
    }
    //HORIZONTAL FORMA
    public boolean reglas4(){
        //HORIZONTALES
        //FORMA
        //IZQUIERDA
        int contFichasHorizontales = 1;
        boolean aplicadaReglaFormaIzq =false;
        boolean aplicadaReglaFormaDer = false;
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas-i][yCas].getFicha() != null){//Si la casilla no tiene ficha
                if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas-i][yCas].getFicha().getForma()&&getJugadorEnTurno().getFichaSeleccionada().getColor()!=getTablero().casilla[xCas-i][yCas].getFicha().getColor()){
                    contFichasHorizontales++;
                    aplicadaReglaFormaIzq =true;
                }else{
                    aplicadaReglaFormaIzq = false;
                    break;
                }
            }else if(i!=1){//salida para cuando recorre todas las fichas puestas a la izquierda
                break;
            }else if(i==1){
                System.out.println("regla agregada como bien");
                aplicadaReglaFormaIzq = true;
                break;
            }
        }
        //DERECHA
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas+i][yCas].getFicha() != null){
                if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas+i][yCas].getFicha().getForma()&&getJugadorEnTurno().getFichaSeleccionada().getColor()!=getTablero().casilla[xCas+i][yCas].getFicha().getColor()){
                    contFichasHorizontales++;
                    aplicadaReglaFormaDer = true;
                }else{
                    aplicadaReglaFormaDer = false;
                    break;
                }
            }else if(i!=1){//salida para cuando recorre todas las fichas puestas a la izquierda
                break;
            }else if(i==1){
                System.out.println("regla agregada como bien");
                aplicadaReglaFormaDer = true;
                break;
            }
        }
        if(contFichasHorizontales>6){
            System.out.println("Te pasaste de fichas HORIZONTALES mi chavo FORMA");
            return false;
        }
        if (aplicadaReglaFormaDer==false || aplicadaReglaFormaIzq==false){
            System.out.println("Salida mal regla 4");
            return false;
        }
        System.out.println("Salida bien regla 4");
        return true;
    }
    //VERTICAL COLOR
    public boolean reglas5(){
        int contFichasVerticales = 1;
        boolean aplicadaReglaColorArr =false;
        boolean aplicadaReglaColorAba = false;
        //VERTICAL
        //COLOR
        //ARRIBA
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas][yCas-i].getFicha() != null){//Si hay ficha en casilla
                if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas][yCas-i].getFicha().getColor()&&getJugadorEnTurno().getFichaSeleccionada().getForma()!=getTablero().casilla[xCas][yCas-i].getFicha().getForma()){//si el color de tu ficha es igual al de la izquierda
                    contFichasVerticales++;
                    aplicadaReglaColorArr = true;
                }else{//si no, entonces no aplica regla color por la izquierda
                    aplicadaReglaColorArr=false;
                    break;
                }
            }else if(i!=1){//salida para cuando recorre todas las fichas puestas a la izquierda
                break;
            }else if(i==1){
                aplicadaReglaColorArr = true;
                break;
            }
        }
        //ABAJO
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas][yCas+i].getFicha() != null){
                if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas][yCas+i].getFicha().getColor()&&getJugadorEnTurno().getFichaSeleccionada().getForma()!=getTablero().casilla[xCas][yCas+i].getFicha().getForma()){
                    contFichasVerticales++;
                    aplicadaReglaColorAba = true;
                }else{
                    aplicadaReglaColorAba = false;
                    break;
                }
            }else if(i!=1){
                break;
            }else if(i==1){
                aplicadaReglaColorAba = true;
                break;
            }
        }
        if(contFichasVerticales>6){
            System.out.println("Te pasaste de fichas VERTICALES mi chavo COLOR");
            return false;
        }
        if (aplicadaReglaColorAba==false || aplicadaReglaColorArr==false){
            System.out.println("Salida mal regla 5");
            return false;
        }
        System.out.println("Salida bien regla 5");
        return true;
    }
    //VERTICAL FORMA
    public boolean reglas6(){
        //VERTICALES
        //FORMA
        //ARRIBA
        int contFichasVerticales = 1;
        boolean aplicadaReglaFormaArr =false;
        boolean aplicadaReglaFormaAba = false;
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas][yCas-i].getFicha() != null){//Si la casilla no tiene ficha
                if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas][yCas-i].getFicha().getForma()&&getJugadorEnTurno().getFichaSeleccionada().getColor()!=getTablero().casilla[xCas][yCas-i].getFicha().getColor()){
                    contFichasVerticales++;
                    aplicadaReglaFormaArr =true;
                }else{
                    aplicadaReglaFormaArr = false;
                    break;
                }
            }else if(i!=1){
                break;
            }else if(i==1){
                aplicadaReglaFormaArr = true;
                break;
            }
        }
        //ABAJO
        for (int i=1; i<=6;i++){
            if (getTablero().casilla[xCas][yCas+i].getFicha() != null){
                if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas][yCas+i].getFicha().getForma()&&getJugadorEnTurno().getFichaSeleccionada().getColor()!=getTablero().casilla[xCas][yCas+i].getFicha().getColor()){
                    contFichasVerticales++;
                    aplicadaReglaFormaAba = true;
                }else{
                    aplicadaReglaFormaAba = false;
                    break;
                }
            }else if(i!=1){
                break;
            }else if(i==1){
                aplicadaReglaFormaAba = true;
                break;
            }
        }
        if(contFichasVerticales>6){
            System.out.println("Te pasaste de fichas VERTICALES mi chavo FORMA");
            return false;
        }
        if (aplicadaReglaFormaArr==false || aplicadaReglaFormaAba==false){
            System.out.println("Salida mal regla 6");
            return false;
        }
        System.out.println("Salida bien regla 6");
        return true;
    }

    /*public boolean reglas7(int caso){
        switch (caso){
            case 0:
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas-i][yCas].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas-i][yCas].getFicha().getForma()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas+i][yCas].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas+i][yCas].getFicha().getForma()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                break;
            case 1:
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas-i][yCas].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas-i][yCas].getFicha().getColor()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas+i][yCas].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas+i][yCas].getFicha().getColor()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                break;
            case 2:
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas][yCas-i].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas][yCas-i].getFicha().getColor()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas][yCas].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getColor()==getTablero().casilla[xCas][yCas+i].getFicha().getColor()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                break;
            case 3:
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas][yCas-i].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas][yCas-i].getFicha().getForma()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                for (int i=1; i<=6;i++){
                    if (getTablero().casilla[xCas][yCas].getFicha() != null){//Si hay ficha en casilla
                        if (getJugadorEnTurno().getFichaSeleccionada().getForma()==getTablero().casilla[xCas][yCas+i].getFicha().getForma()){//si el color de tu ficha es igual al de la izquierda
                            return false;
                        }
                    }
                }
                break;
        }
        return true;
    }*/

    public boolean reglas7(){
        if (getTablero().casilla[xCas-1][yCas].getFicha()!=null){
            return true;
        }
        if (getTablero().casilla[xCas+1][yCas].getFicha()!=null){
            return true;
        }
        if (getTablero().casilla[xCas][yCas-1].getFicha()!=null){
            return true;
        }
        if (getTablero().casilla[xCas][yCas+1].getFicha()!=null){
            return true;
        }
        return false;
    }
    public void asignarRegla(){
        getTablero().ponerFicha(getJugadorEnTurno().getFichaSeleccionada(),xCas,yCas);
        jugadorEnTurno.removerFicha(jugadorEnTurno.getFichaSeleccionada());
    }
}