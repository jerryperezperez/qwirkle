package Model;

import com.sun.org.apache.xerces.internal.impl.ExternalSubsetResolver;

import java.util.ArrayList;

public class BotEquipo7 extends Bot {
    private Casilla casillaHeuristica;
    private String estructuraHeuristica;

    @Override
    public void analizarEstrategia() throws Exception {
        if (casillaHeuristica == null) {
            this.definirLinea();
        } else {
            if (estructuraHeuristica.equals("FILA")) {
                this.insertarEnLineaFila(this.buscarFila());
            } else {
                if (estructuraHeuristica.equals("COLUMNA")) {
                    this.insertarEnLineaColumna(this.buscarColumna());
                }
            }
        }
        if (this.cambioFichaDisponible && this.iterador == 5) {
            System.out.println("VA A CAMBIAR FICHAS PORQUE NO HA ENCONTRADO PARA PONER");

        }
    }

    public Estructura buscarColumna() throws Exception {
        for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
            if (columna.getCola().contains(this.casillaHeuristica) && columna.getCola().size() < 6) {
                return columna;
            } else {
                throw new Exception("LA ESTRUCTURA YA TIENE 6 FICHAS");
            }
        }
        throw new Exception("NO ENCONTRÓ LA FICHA AGREGADA EN LAS ESTRUCTURAS");
    }

    public Estructura buscarFila() throws Exception {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            if (fila.getCola().contains(this.casillaHeuristica) && fila.getCola().size() < 6) {
                return fila;
            } else {
                throw new Exception("LA ESTRUCTURA YA TIENE 6 FICHAS");
            }
        }
        throw new Exception("NO ENCONTRÓ LA FICHA AGREGADA EN LAS ESTRUCTURAS");
    }

    public boolean insertarEnLineaColumna(Estructura estructura) {
        //BUSCA INSERTAR EN COLUMNAS
        for (Ficha ficha : this.getArregloFichas()) {
            try {
                this.controladorEstructura.agregar(estructura.getCola().getLast().getCasillaInferior(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getLast().setFicha(null);
                this.casilla = estructura.getCola().getLast();
                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }
            try {
                this.controladorEstructura.agregar(estructura.getCola().getFirst().getCasillaSuperior(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getFirst().setFicha(null);
                this.casilla = estructura.getCola().getFirst();
                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }
        }
        return false;
    }

    public boolean insertarEnLineaFila(Estructura estructura) {
        for (Ficha ficha : this.getArregloFichas()) {
            try {
                this.controladorEstructura.agregar(estructura.getCola().getLast().getCasillaDerecha(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getLast().setFicha(null);
                this.casilla = estructura.getCola().getLast();
                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }
            try {
                this.controladorEstructura.agregar(estructura.getCola().getFirst().getCasillaIzquierda(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getFirst().setFicha(null);
                this.casilla = estructura.getCola().getFirst();
                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }

        }
        return false;
    }

    //Se usa para cuando no su línea original ya ha sido ocupada y necesita buscar una nueva
    public boolean definirLinea() {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            for (Ficha ficha : this.getArregloFichas()) {
                try {
                    this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                    this.setFichaSeleccionada(ficha);
                    fila.getCola().getLast().setFicha(null);
                    this.casilla = fila.getCola().getLast();
                    this.casillaHeuristica = this.casilla;
                    this.estructuraHeuristica = "FILA";
                    this.cambioFichaDisponible = false;
                    return true;
                } catch (Exception e) {
                    //   e.printStackTrace();
                }
                try {
                    this.controladorEstructura.agregar(fila.getCola().getFirst().getCasillaIzquierda(), ficha);
                    this.setFichaSeleccionada(ficha);
                    fila.getCola().getFirst().setFicha(null);
                    this.casilla = fila.getCola().getFirst();
                    this.estructuraHeuristica = "FILA";
                    this.casillaHeuristica = this.casilla;
                    this.cambioFichaDisponible = false;
                    return true;
                } catch (Exception e) {
                    //   e.printStackTrace();
                }
            }
        }
        for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
            for (Ficha ficha : this.getArregloFichas()) {
                try {
                    this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                    this.setFichaSeleccionada(ficha);
                    columna.getCola().getLast().setFicha(null);
                    this.casilla = columna.getCola().getLast();
                    this.estructuraHeuristica = "COLUMNA";
                    this.casillaHeuristica = this.casilla;
                    this.cambioFichaDisponible = false;
                    return true;

                } catch (Exception e) {
                    //   e.printStackTrace();
                }
                try {
                    this.controladorEstructura.agregar(columna.getCola().getFirst().getCasillaSuperior(), ficha);
                    this.setFichaSeleccionada(ficha);
                    columna.getCola().getFirst().setFicha(null);
                    this.casilla = columna.getCola().getFirst();
                    this.estructuraHeuristica = "COLUMNA";
                    this.casillaHeuristica = this.casilla;
                    this.cambioFichaDisponible = false;
                    return true;
                } catch (Exception e) {
                    //   e.printStackTrace();
                }
            }
        }

        return false;
    }

    //Se define la mejor estructura para cuando se juega en primer turno
    public void detectarUltimaMejorEstructura() {

    }

    @Override
    public void iniciarPartida() {
        this.setFichaSeleccionada(this.fichas.get(2));
        this.casilla = new Casilla(12, 8);
        this.casillaHeuristica = casilla;
    }

    @Override
    public ArrayList<Ficha> cambiarFichas() {
        System.out.println("ENTRA EN MÉTODO DE CAMBIAR FICHAS");
        ArrayList<Ficha> arregloCambioFichas = new ArrayList<>();
        arregloCambioFichas.add(this.fichas.get(1));
        this.removerFicha(this.fichas.get(1));
        arregloCambioFichas.add(this.fichas.get(3));
        this.removerFicha(this.fichas.get(3));
        arregloCambioFichas.add(this.fichas.get(4));
        this.removerFicha(this.fichas.get(4));
        return arregloCambioFichas;
    }
}
