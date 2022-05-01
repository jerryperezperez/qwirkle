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

    public boolean isDuplicated(Ficha ficha) {
        for (Casilla casilla : this.colas) {
            if (casilla.getFicha().equals(ficha)) {
                return true;
            }
        }
        return false;
    }

    public boolean cumpleRestriccion(Ficha ficha) throws Exception {
        switch (this.restriccion) {
            case "LIBRE":
                this.designarRestriccion(ficha);
                break;
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
                throw new Exception("NO PUEDE CUMPLIR NI EN FORMA O COLOR");
            }
        }
    }

    public LinkedList<Casilla> getColas() {
        return colas;
    }


}
