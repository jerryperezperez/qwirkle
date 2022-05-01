package Model;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jerry
 */
public class Qwirkle2 {

    public static void main(String[] args) {
        Regla regla = new Regla();

        try {
            regla.metodo1(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(regla.cadena);
        // Juego juego = new Juego(2);
        //  juego.intercambiarFicha();

        LinkedList<String> cola = new LinkedList<>();
        LinkedList<String> cola2 = new LinkedList<>();
        ArrayList<LinkedList<String>> arreglo = new ArrayList<>();
        cola2.add("d");
        cola.add("a");
        cola.add("a");
        arreglo.add(cola2);
        arreglo.add(cola);


        for (LinkedList<String> colita : arreglo) {
            System.out.println("IMPRESION PRIMERA COLA");
            for (String elemento : colita) {
                System.out.println(elemento);
            }
        }
        System.out.println("Recorrer por la izquierda, ultimo elemento");
        for (LinkedList<String> colita : arreglo) {
            if (colita.getLast().equals("d")) {
                System.out.println("encontró estructura a la izquierda");
                System.out.println("Retonar estructura.Casi imposible que no encuentre la estructura");
            }
        }

        System.out.println("Recorrer por la derecha, primer elemento");
        for (LinkedList<String> colita : arreglo) {
            if (colita.getFirst().equals("a")) {
                System.out.println("encontró estructura a la derecha");
                System.out.println("Retonar estructura.Casi imposible que no encuentre la estructura");
            }
        }
        cola2.add("c");
        cola2.addAll(arreglo.remove(arreglo.indexOf(cola)));

        for (LinkedList<String> colita : arreglo) {
            System.out.println("IMPRESION PRIMERA COLA");
            for (String elemento : colita) {
                System.out.println(elemento);
            }
        }

    }


}

