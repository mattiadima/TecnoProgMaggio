package com.example.demo.Entity;

public class nave {
    private int ID;
    private String nome;
    private String tipo;
    public int getID() {
        return ID;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public nave(int iD, String nome, String tipo) {
        ID = iD;
        this.nome = nome;
        this.tipo = tipo;
    }

}
