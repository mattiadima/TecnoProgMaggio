package com.example.demo.Entity;

public class utente {
    private int ID;
    private String username;
    private String password;
    
    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public utente(int iD, String username, String password) {
        this.ID = iD;
        this.username = username;
        this.password = password;
    }
}
