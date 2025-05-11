package com.example.demo.Entity;

public class buono {
    private int ID;
    private double peso;
    private polizza polizza;
    private String data;
    public buono(int iD, double peso, com.example.demo.Entity.polizza polizza, String data) {
        ID = iD;
        this.peso = peso;
        this.polizza = polizza;
        this.data = data;
    }
    public int getID() {
        return ID;
    }
    public double getPeso() {
        return peso;
    }
    public polizza getPolizza() {
        return polizza;
    }
    public String getData() {
        return data;
    }
}
