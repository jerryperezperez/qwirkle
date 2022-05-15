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



    }


}

