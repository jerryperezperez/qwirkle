package Model;

import java.util.ArrayList;

public final class Regla {



    public void metodo1(int valor) throws Exception {

    }

  public static boolean cumpleRestriccion(Estructura estructura, Ficha ficha) throws Exception {
      switch (estructura.getRestriccion()) {
          case "FORMA":
              if (!estructura.getCola().getFirst().getFicha().getForma().equals(ficha.getForma())) {
                  throw new Exception("NO CUMPLE CON LA FORMA");
              }
              break;
          case "COLOR":
              if (!estructura.getCola().getFirst().getFicha().getColor().equals(ficha.getColor())) {
                  throw new Exception("NO CUMPLE CON EL COLOR");
              }
              break;
      }
      return true;
  }

  /*  public static int agregar(Casilla casilla, Ficha ficha) throws Exception {

        if (casilla.getCasillaIzquierda().getFicha() != null && casilla.getCasillaDerecha().getFicha() != null) {
            if (this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getRestriccion().equals(this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getRestriccion())) {

            } else {
                throw new Exception("TIENEN DIFERENTES RESTRICCIONES LAS COLAS, NO ES POSIBLE SU UNIÓN.");
            }
        }
        if (casilla.getCasillaIzquierda().getFicha() != null) {
            this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).isDuplicated(ficha);
            if (!this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).estaCondicionada()) {
                System.out.println("ENTRA EN PRIMER IF de casilla izquierda");
                this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).designarRestriccion(ficha);
            } else {
                System.out.println("ENTRA EN ELSE");
                this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getCola().addLast(casilla);
            //  System.out.println("PUNTOS GANADOS EN HORIZONTAL: " + this.recuperarEstructuraInicial(this.estructuraFilas, casilla).getCola().size());
        }
        if (casilla.getCasillaDerecha().getFicha() != null) {
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).isDuplicated(ficha);
            if (!this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).estaCondicionada()) {
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).designarRestriccion(ficha);
                System.out.println("ENTRA EN PRIMER IF");
            } else {
                System.out.println("ENTRA EN PRIMER ELSE");
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getCola().addFirst(casilla);
            // System.out.println("PUNTOS GANADOS EN HORIZONTAL: " + this.recuperarEstructuraFinal(this.estructuraFilas, casilla).getCola().size());

        }
        if (casilla.getCasillaSuperior().getFicha() != null) {
            this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).isDuplicated(ficha);
            if (!this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).estaCondicionada()) {
                System.out.println("ENTRA EN PRIMER IF");
                this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).designarRestriccion(ficha);
            } else {
                System.out.println("ENTRA EN ELSE");
                this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).getCola().addLast(casilla);
            // System.out.println("PUNTOS GANADOS EN VERTICAL: " + this.recuperarEstructuraInicial(this.estructuraColumnas, casilla).getCola().size());

        }
        if (casilla.getCasillaInferior().getFicha() != null) {
            this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).isDuplicated(ficha);
            if (!this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).estaCondicionada()) {
                this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).designarRestriccion(ficha);
                System.out.println("ENTRA EN PRIMER IF");
            } else {
                System.out.println("ENTRA EN PRIMER ELSE");
                this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).cumpleRestriccion(ficha);
            }
            this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).getCola().addFirst(casilla);
            //System.out.println("PUNTOS GANADOS EN VERTICAL: " + this.recuperarEstructuraFinal(this.estructuraColumnas, casilla).getCola().size());

        }
        this.crearEstructuraFila(casilla);
        this.crearEstructuraColumna(casilla);
        this.imprimirEstructuras();
        casilla.setFicha(ficha);
        System.out.println("PUNTOS GANADOS:     " + this.recuperarLongitudEstructura(casilla));

        return this.recuperarLongitudEstructura(casilla);
    }*/
}
