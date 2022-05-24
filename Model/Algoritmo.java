
package Model;

import java.util.ArrayList;
import java.util.Stack;

public class Algoritmo {
    private Nodo nodoInicial;

    private Stack<Nodo> nodosVisitados = new Stack();
    public ArrayList<Nodo> mejorRuta = new ArrayList();
    private Stack<Nodo> rutaActual = new Stack();

    public Algoritmo(Nodo nodo) {
        this.nodoInicial = nodo;
        this.ejecutar(this.nodoInicial);
    }

    public void ejecutar(Nodo nodoActual) {
            if (!nodosVisitados.contains(nodoActual)) {
                for (Nodo nodoHijo : nodoActual.getNodos()) {
                        rutaActual.add(nodoHijo);
                        this.nodosVisitados.add(nodoHijo);
                    // this.detectarRutaCorta(rutaActual);
                    this.ejecutar(nodoHijo);
                }
                this.detectarRutaCorta(rutaActual);
                if (!this.rutaActual.isEmpty()) {
                    this.rutaActual.pop();
                    this.nodosVisitados.pop();
                    System.out.println("RETROCEDE");
                }
                return;
            }
    }

    public void detectarRutaCorta(Stack<Nodo> rutaActual) {
        if (mejorRuta.isEmpty()) {
            mejorRuta.addAll(rutaActual);
        } else if (mejorRuta.get(mejorRuta.size()-1).cantidadFichasAfectadas()> rutaActual.get(rutaActual.size()-1).cantidadFichasAfectadas()) {
            mejorRuta.clear();
            mejorRuta.addAll(rutaActual);
        }
    }

   public void imprimirMejorRuta() {
        System.out.println("IMPRIMIENDO MEJOR RUTA");
        if (mejorRuta.isEmpty()) {
            System.out.println("OBJETIVO ALCANZADO");

        } else {

            for (Nodo nodo : mejorRuta) {
                System.out.println(nodo.toString());
            }
            System.out.println("--------------");
        }
    }

  /*  public void imprimirPila() {
        for (Jugador nodosVisitado : nodosVisitados) {
            System.out.println(nodosVisitado.toString());
        }
        System.out.println("--------------");
    }*/
}

