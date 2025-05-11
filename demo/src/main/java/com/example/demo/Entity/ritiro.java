package com.example.demo.Entity;

public class ritiro {
    private int ID;
    private camion targa;
    private autista autista;
    private double peso;
    private String data;
    public int getID() {
        return ID;
    }
    public camion getTarga() {
        return targa;
    }
    public autista getAutista() {
        return autista;
    }
    public double getPeso() {
        return peso;
    }
    public String getData() {
        return data;
    }
    public ritiro(int iD, camion targa, com.example.demo.Entity.autista autista, double peso, String data) {
        ID = iD;
        this.targa = targa;
        this.autista = autista;
        this.peso = peso;
        this.data = data;
    }
    
    


}
