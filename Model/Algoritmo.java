
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
                this.nodosVisitados.add(nodoActual);
                this.rutaActual.add(nodoActual);
                for (Nodo nodoHijo : nodoActual.getNodos()) {
//                        rutaActual.add(nodoHijo);
                        // this.nodosVisitados.add(nodoHijo);
                    // this.detectarRutaCorta(rutaActual);
                    this.ejecutar(nodoHijo);
                }
//                this.nodosVisitados.add(nodoActual);
//                this.detectarRutaCorta(rutaActual);
                if (!this.rutaActual.isEmpty()) {
                    this.detectarRutaCorta(rutaActual);

                    for (int i = 1; i < nodosVisitados.size(); i ++)
                    {
                        System.out.println(nodosVisitados.get(i).casillaBot.toString());
                    }
                    System.out.println("RETROCEDE");
                    this.rutaActual.pop();
                    this.nodosVisitados.pop();
                }
                return;
            }
    }

    public void detectarRutaCorta(Stack<Nodo> rutaActual) {
        if (mejorRuta.isEmpty()) {
            mejorRuta.addAll(rutaActual);
        } else if (mejorRuta.get(mejorRuta.size()-1).cantidadFichasAfectadas()> rutaActual.get(rutaActual.size()-1).cantidadFichasAfectadas()) {
            System.out.println("PUNTOS DE MEJOR RUTA: " + mejorRuta.get(mejorRuta.size()-1).cantidadFichasAfectadas() + " PUNTOS DE RUTA ACTUAL: " + rutaActual.get(rutaActual.size()-1).cantidadFichasAfectadas());
            mejorRuta.clear();
            mejorRuta.addAll(rutaActual);
        }
    }

   public void imprimirMejorRuta() {
        System.out.println("IMPRIMIENDO MEJOR RUTA");
        if (mejorRuta.isEmpty()) {
            System.out.println("OBJETIVO ALCANZADO");

        } else {
            System.out.println("LONGITUD DE LA RUTA ES:" + this.mejorRuta.size());
            for (Nodo nodo : mejorRuta) {
                if (nodo.casillaBot == null){
                    System.out.println("es nulo");
                }else{

                System.out.println(nodo.casillaBot.toString());
                }
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

