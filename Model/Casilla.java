/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Objects;

public class Casilla implements Comparable<Casilla> {

    private int x;
    private int y;
    private Ficha ficha;
    private Casilla casillaSuperior;
    private Casilla casillaInferior;
    private Casilla casillaIzquierda;
    private Casilla casillaDerecha;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void setCasillaSuperior(Casilla casillaSuperior) {
        this.casillaSuperior = casillaSuperior;
    }

    public void setCasillaInferior(Casilla casillaInferior) {
        this.casillaInferior = casillaInferior;
    }

    public void setCasillaIzquierda(Casilla casillaIzquierda) {
        this.casillaIzquierda = casillaIzquierda;
    }

    public void setCasillaDerecha(Casilla casillaDerecha) {
        this.casillaDerecha = casillaDerecha;
    }

    public Casilla getCasillaSuperior() {
        return casillaSuperior;
    }

    public Casilla getCasillaInferior() {
        return casillaInferior;
    }

    public Casilla getCasillaDerecha() {
        return casillaDerecha;
    }

    public Casilla getCasillaIzquierda() {
        return casillaIzquierda;
    }

    public Casilla(int x, int y, Ficha ficha) {
        this.x = x;
        this.y = y;
        this.ficha = ficha;
    }

    public boolean findCasilla(Casilla casilla) {
        if (this.casillaSuperior.getFicha() != null && this.casillaSuperior.getFicha().equals(casilla.getFicha())) {
            return true;
        } else {
            if (this.casillaInferior.getFicha() != null && this.casillaInferior.getFicha().equals(casilla.getFicha())) {
                return true;
            } else {
                if (this.casillaIzquierda.getFicha() != null && this.casillaIzquierda.getFicha().equals(casilla.getFicha())) {
                    return true;
                } else {
                    if (this.casillaDerecha.getFicha() != null && this.casillaDerecha.getFicha().equals(casilla.getFicha())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    public Casilla() {
        this.x = 0;
        this.y = 0;
        this.ficha = null;
    }


    @Override
    public String toString() {
        return "Casilla{" +
                "x=" + x +
                ", y=" + y +
                ", ficha=" + ficha +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y, ficha);
    }

    @Override
    public int compareTo(Casilla o) {
        if (this.x > o.x) {
            return 1;
        } else {
            if (this.x == o.x) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
