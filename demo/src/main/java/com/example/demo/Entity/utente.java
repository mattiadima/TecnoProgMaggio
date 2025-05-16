package com.example.demo.Entity;

public class utente {
    private int ID;
    private String username;
    private String privilegio;
    
    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return privilegio;
    }

    public utente(int iD, String username, String privilegio) {
        this.ID = iD;
        this.username = username;
        this.privilegio = privilegio;
    }
}
