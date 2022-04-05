/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Ficha {

    private static int ID = 1;
    private int id = 1;
    private String forma;
    private String color;

    public Ficha (){
        this.id = 0;
        this.forma = "";
        this.color = "";
    }
    public Ficha(String forma, String color) {
        this.id = this.ID;
        this.ID += 1;
        this.forma = forma;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }



}
