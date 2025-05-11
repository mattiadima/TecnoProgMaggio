package com.example.demo.Entity;

public class autista {
    private int ID;
    private String nome;
    private String username;
    private String password;

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public autista(int iD, String nome, String username, String password) {
        this.ID = iD;
        this.nome = nome;
        this.username = username;
        this.password = password;
    }

}
