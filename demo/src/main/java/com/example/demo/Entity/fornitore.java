package com.example.demo.Entity;

public class fornitore {
    private int ID;
    private String nome;
    private String cognome;
    private String mail;
    private String tel;
    private String password;

    public int getID() {
        return ID;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getMail() {
        return mail;
    }
    public String getTel() {
        return tel;
    }
    public String getPassword() {
        return password;
    }

    public fornitore(int iD, String nome, String cognome, String mail, String tel, String password) {
        this.ID = iD;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.tel = tel;
        this.password = password;
    }





}