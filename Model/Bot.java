package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Bot extends Jugador {
    public Bot() {
    }

    public void iniciar(ArrayList<Estructura> estructuraFilas, ArrayList<Estructura> estructuraColumnas){
        System.out.println("SOY EL BOT");
        estructuraColumnas.sort(new Comparator<Estructura>() {
            @Override
            public int compare(Estructura o1, Estructura o2) {
                return o2.getCola().size() - o1.getCola().size();
            }
        });
        System.out.println("COLAS ORDENADAS POR EL BOT");

    }

    public void formarQwirkle(ArrayList<Estructura> estructuraFilas, ArrayList<Estructura> estructuraColumnas) throws Exception {
        for (Estructura columna: estructuraColumnas) {
            if (columna.getCola().size() ==5){
                for (Ficha ficha: this.getArregloFichas()) {
                    if (Regla.cumpleRestriccion(columna,ficha )){
                        if (columna.getCola().getLast().getCasillaInferior() != null){

                        }else{
                            if (columna.getCola().getFirst().getCasillaSuperior() != null){

                            }
                        }
                    }
                }
            }

        }
        for (Estructura columnas: estructuraColumnas) {
            if (columnas.getCola().size() ==5)
                System.out.println(columnas.getCola().size());
        }
    }
}
