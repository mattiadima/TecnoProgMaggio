package com.example.demo.Entity;

public class porto {
    private int ID;
    private String nome;
    private String rotta;
    private String nazione;
    
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getRotta() {
        return rotta;
    }

    public String getNazione() {
        return nazione;
    }

    public porto(int iD, String nome, String rotta, String nazione) {
        ID = iD;
        this.nome = nome;
        this.rotta = rotta;
        this.nazione = nazione;
    }


}
