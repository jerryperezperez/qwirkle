package Model;

import sun.misc.Queue;

import java.util.*;
//TODO crear clase padre de EstructuraFila y EstructuraColumna
public class EstructuraColumna {
    private LinkedList<Casilla> columnas;
    private String restriccion; //LIBRE, COLOR, FORMA

    public EstructuraColumna(Casilla casilla) {
        this.columnas = new LinkedList<>();
        this.columnas.add(casilla);
        this.restriccion = "LIBRE";
    }

    public LinkedList<Casilla> getColumnas() {
        return columnas;
    }
    public boolean addToLeft(Casilla casilla, Ficha ficha) {
        if (this.isRestriccionPermitida(ficha)) {
            this.columnas.addFirst(casilla);
            return true;
        }
        return false;
    }
    public boolean isRestriccionPermitida(Ficha ficha) {
        System.out.println("entra en restricción");
        switch (this.restriccion) {
            case "LIBRE":
                if (!this.designarRestriccion(ficha)) {
                    return false;
                }
                break;
            case "FORMA":
                if (!this.columnas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
                    System.out.println("falso en forma");
                    return false;
                } else {
                    break;
                }
            case "COLOR":
                if (!this.columnas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
                    System.out.println("falso en color");
                    return false;
                } else {
                    break;
                }
        }
        System.out.println("retorna true isRestriccionValida");
        return true;
    }
    public boolean designarRestriccion(Ficha ficha) {
        if (this.columnas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
            this.restriccion = "COLOR";
        } else {
            if (this.columnas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
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
