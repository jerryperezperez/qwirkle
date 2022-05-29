package Model;

import java.util.ArrayList;

public class BotAvanzado5Fallido extends Bot{

    public BotAvanzado5Fallido(){
        super("Bot Avanzado fallido");
    }
    ControladorEstructura controladorAuxiliar;
    @Override
    public void analizarEstrategia() throws Exception {
        controladorAuxiliar = new ControladorEstructura(controladorEstructura);
      /*  for (Ficha ficha: this.fichas) {
            System.out.println(ficha);
        }*/
        this.getNodos();
       /* Nodo nodo = new Nodo(this.controladorEstructura, this.fichas);
        Algoritmo algoritmo = new Algoritmo(nodo);
        for (Nodo nodo2: algoritmo.mejorRuta) {
            System.out.println(nodo2.fichaBot);
        }*/
    }

    @Override
    public void iniciarPartida() {

    }

    @Override
    public ArrayList<Ficha> cambiarFichas() {
        return null;
    }

    public void getNodos() {
        for (Ficha ficha : this.fichas) {
            //RECORRER CADA FICHA POR CADA FILA POR IZQUIERDA Y DERECHA
            for (Estructura estructuraFila : this.controladorAuxiliar.getEstructuraFilas()) {

                controladorAuxiliar.imprimirCantidadEstructuras();
                try {
                    controladorAuxiliar.agregar(estructuraFila.getCola().getFirst().getCasillaIzquierda(), ficha);
                    this.setFichaSeleccionada(ficha);
                    estructuraFila.getCola().getFirst().setFicha(null);
                    this.casilla = estructuraFila.getCola().getFirst().getCasillaIzquierda();
                  //  nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraFila.getCola().getFirst().getCasillaIzquierda(), ficha, this.fichasJugador));
                    System.out.println("HA CREADO NODO");

                } catch (Exception e) {

                }
                controladorAuxiliar = new ControladorEstructura(controladorEstructura);
                controladorAuxiliar.imprimirCantidadEstructuras();

                try {
                    controladorAuxiliar.agregar(estructuraFila.getCola().getLast().getCasillaDerecha(), ficha);
                    this.setFichaSeleccionada(ficha);
                    estructuraFila.getCola().getLast().setFicha(null);

                    this.casilla = estructuraFila.getCola().getLast().getCasillaDerecha();
                   // nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraFila.getCola().getLast().getCasillaDerecha(), ficha, this.fichasJugador));
                    System.out.println("HA CREADO NODO");
                } catch (Exception e) {

                }
            }
            //RECORRER CADA FICHA POR CADA COLUMNA POR ARRIBA Y ABAJO
            for (Estructura estructuraColumna : this.controladorAuxiliar.getEstructuraColumnas()) {
                controladorAuxiliar = new ControladorEstructura(controladorEstructura);
                controladorAuxiliar.imprimirCantidadEstructuras();

                try {
                    controladorAuxiliar.agregar(estructuraColumna.getCola().getFirst().getCasillaSuperior(), ficha);
                    this.setFichaSeleccionada(ficha);
                    estructuraColumna.getCola().getFirst().setFicha(null);

                    this.casilla = estructuraColumna.getCola().getFirst().getCasillaSuperior();
                   // nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraColumna.getCola().getFirst().getCasillaSuperior(), ficha, this.fichasJugador));
                    System.out.println("HA CREADO NODO");
                } catch (Exception e) {


                }
                controladorAuxiliar = new ControladorEstructura(controladorEstructura);
                controladorAuxiliar.imprimirCantidadEstructuras();

                try {
                    controladorAuxiliar.agregar(estructuraColumna.getCola().getLast().getCasillaInferior(), ficha);
                    this.setFichaSeleccionada(ficha);
                    estructuraColumna.getCola().getLast().setFicha(null);

                    this.casilla = estructuraColumna.getCola().getLast().getCasillaInferior();
                   // nodosApuntados.add(new Nodo(controladorAuxiliar, estructuraColumna.getCola().getLast().getCasillaInferior(), ficha, this.fichasJugador));
                    System.out.println("HA CREADO NODO");
                } catch (Exception e) {


                }
            }
        }

    }

}
