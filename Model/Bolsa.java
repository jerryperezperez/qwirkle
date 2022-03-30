
package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jerry
 */
public class Bolsa {

    ArrayList<Ficha> fichas = new ArrayList<>();
    private static String formas[] = {"cuadrado", "circulo", "rombo", "tacha", "cruz", "estrella"};
    private static String colores[] = {"verde", "rojo", "morado", "amarillo", "azul", "naranja"};

    public Bolsa() {

        for (String forma : formas) {
            for (String color : colores) {
                for (int i = 0; i < 3; i++) {
                    this.fichas.add(new Ficha(forma, color));
                }
            }
        }
        System.out.println("CANTIDAD DE FICHAS CREADAS: " + fichas.size());
    }

    public Ficha darFicha() {
        Random rand = new Random();//método que devuelve una ficha y la elimina del arreglo
        int i;
        i = rand.nextInt(this.fichas.size());
        return this.fichas.remove(i);
       
    }
//MÉTODO DE INTERCAMBIO DE FICHAS. POSIBLE MODIFICACIÓN

    public Ficha intercambiarFicha(Ficha fichaDeCambio) {

        Ficha fichaDeCambio2 = this.darFicha();
        this.fichas.add(fichaDeCambio);
        return fichaDeCambio2;

    }
}
