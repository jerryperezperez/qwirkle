package Model;

import java.util.LinkedList;

public class Estructura {
    protected LinkedList<Casilla> colas;
    protected String restriccion;

    public Estructura(Casilla casilla) {
        this.colas = new LinkedList<>();
        this.colas.add(casilla);
        this.restriccion = "LIBRE";
    }

    public boolean addToRight(Casilla casilla, Ficha ficha) throws Exception {
        if (!this.isDuplicated(ficha)) {
            if (this.cumpleRestriccion(ficha)) {
                this.colas.addLast(casilla);
                return true;
            } else {
                return false;
            }
        } else {
            throw new Exception("LA FICHA YA HA SIDO AGREGADA EN ESTA COLA");
        }
    }

    public boolean addToLeft(Casilla casilla, Ficha ficha) throws Exception {
        if (!this.isDuplicated(ficha)) {
            if (this.cumpleRestriccion(ficha)) {
                this.colas.addFirst(casilla);
                return true;
            } else {
                return false;
            }
        } else {
            throw new Exception("LA FICHA YA HA SIDO AGREGADA EN ESTA COLA");
        }
    }

    public boolean isDuplicated(Ficha ficha) throws Exception {
        for (Casilla casilla : this.colas) {
            if (casilla.getFicha().equals(ficha)) {
                throw new Exception("LA FICHA YA HA SIDO AGREGADA EN ESTA COLA");
            }
        }
        return false;
    }

    public boolean cumpleRestriccion(Ficha ficha) throws Exception {
        switch (this.restriccion) {
            case "FORMA":
                if (!this.colas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
                    throw new Exception("NO CUMPLE CON LA FORMA");
                }
                break;
            case "COLOR":
                if (!this.colas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
                    throw new Exception("NO CUMPLE CON EL COLOR");
                }
                break;
        }
        return true;
    }

    public void designarRestriccion(Ficha ficha) throws Exception {
        if (this.colas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
            this.restriccion = "COLOR";
        } else {
            if (this.colas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
                this.restriccion = "FORMA";
            } else {
                throw new Exception("NO SE PUEDE ASIGNAR RESTRICCIÓN. NO ES NI EN COLOR O EN FORMA");
            }
        }
    }

    public void encontrarColaIzquierda() {

    }

    public void encontrarColaDerecha() {

    }

    public String getRestriccion() {
        return restriccion;
    }

    public boolean estaCondicionada() {
        if (this.restriccion.equals("LIBRE")) {
            return false;
        }
        return true;
    }

    public LinkedList<Casilla> getCola() {
        return colas;
    }


}
