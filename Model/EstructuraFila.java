package Model;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;

public class EstructuraFila {
    private LinkedList<Casilla> filas;
    private String restriccion; //LIBRE, COLOR, FORMA

    public EstructuraFila(Casilla casilla) {
        this.filas = new LinkedList<>();
        this.filas.add(casilla);
        this.restriccion = "LIBRE";
    }

    public LinkedList<Casilla> getFilas() {
        return filas;
    }

    public Casilla[] getFilas2() {
        return (Casilla[]) filas.clone();
    }


    public boolean addToRight(Casilla casilla, Ficha ficha) {
        if (this.isRestriccionPermitida(ficha)) {
            this.filas.addLast(casilla);
            return true;
        }
        return false;
    }

    public boolean addToLeft(Casilla casilla, Ficha ficha) {
        if (this.isRestriccionPermitida(ficha)) {
            this.filas.addFirst(casilla);
            return true;
        }
        return false;
    }

    public boolean isDuplicated(Ficha ficha) {
        for (Casilla casilla : this.filas) {
            if (casilla.getFicha().equals(ficha)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRestriccionPermitida(Ficha ficha) {
        System.out.println("RECORRIENDO FILA ");
        System.out.println("COMPARACIÓN FINAL: " + this.filas.getFirst().equals(ficha));

        System.out.println(this.filas.getFirst().toString() + " = " + ficha.toString());

        System.out.println("LA FILA CONTIENE: " + this.filas.contains(ficha));
        if (!this.isDuplicated(ficha)) {
            System.out.println("entra en restricción");
            switch (this.restriccion) {
                case "LIBRE":
                    if (!this.designarRestriccion(ficha)) {
                        return false;
                    }
                    break;
                case "FORMA":
                    if (!this.filas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
                        System.out.println("falso en forma");
                        return false;
                    } else {
                        break;
                    }
                case "COLOR":
                    if (!this.filas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
                        System.out.println("falso en color");
                        return false;
                    } else {
                        break;
                    }
            }
            System.out.println("retorna true isRestriccionValida");
            return true;
        }
        System.out.println("LA FICHA YA EXISTE EN ESTRUCTURA");
        return false;
    }


    public boolean designarRestriccion(Ficha ficha) {
        if (this.filas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
            this.restriccion = "COLOR";
        } else {
            if (this.filas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
                this.restriccion = "FORMA";
            } else {
                return false;
            }
        }
        return true;
    }

    public String getRestriccion() {
        return restriccion;
    }
}
