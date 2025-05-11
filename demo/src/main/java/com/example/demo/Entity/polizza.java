package com.example.demo.Entity;

public class polizza {
    private int ID;
    private cliente cliente;
    private viaggio viaggio;
    private String merce;
    private String data;
    private double peso;
    public int getID() {
        return ID;
    }
    public cliente getCliente() {
        return cliente;
    }
    public viaggio getViaggio() {
        return viaggio;
    }
    public String getMerce() {
        return merce;
    }
    public String getData() {
        return data;
    }
    public double getPeso() {
        return peso;
    }
    public polizza(int iD, com.example.demo.Entity.cliente cliente, com.example.demo.Entity.viaggio viaggio,
            String merce, String data, double peso) {
        ID = iD;
        this.cliente = cliente;
        this.viaggio = viaggio;
        this.merce = merce;
        this.data = data;
        this.peso = peso;
    }
}
