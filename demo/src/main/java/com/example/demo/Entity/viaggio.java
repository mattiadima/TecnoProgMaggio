package com.example.demo.Entity;

public class viaggio {
    private int ID;
    private fornitore fornitore;
    private String data_p;
    private String data_a;
    private porto porto_a;
    private porto porto_p;
    private nave nave;
    public viaggio(int iD, com.example.demo.Entity.fornitore fornitore, String data_p, String data_a, porto porto_a,
            porto porto_p, com.example.demo.Entity.nave nave) {
        ID = iD;
        this.fornitore = fornitore;
        this.data_p = data_p;
        this.data_a = data_a;
        this.porto_a = porto_a;
        this.porto_p = porto_p;
        this.nave = nave;
    }
    public int getID() {
        return ID;
    }
    public fornitore getFornitore() {
        return fornitore;
    }
    public String getData_p() {
        return data_p;
    }
    public String getData_a() {
        return data_a;
    }
    public porto getPorto_a() {
        return porto_a;
    }
    public porto getPorto_p() {
        return porto_p;
    }
    public nave getNave() {
        return nave;
    }

}
