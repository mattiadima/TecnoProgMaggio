package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.*;
import com.example.demo.Entity.*;

import java.util.List;

@RestController
@RequestMapping("/visualizza")
public class ControllerVisualizza {

    AutistaDao autistaDao = new AutistaDao();
    CamionDao camionDao = new CamionDao();
    ClienteDao clienteDao = new ClienteDao();
    FornitoreDao fornitoreDao = new FornitoreDao();
    NaveDao naveDao = new NaveDao();
    PortoDao portoDao = new PortoDao();
    ViaggioDao viaggioDao = new ViaggioDao();
    PolizzaDao polizzaDao = new PolizzaDao();
    buonoDao buonoDao = new buonoDao();
    RitiroDao ritiroDao = new RitiroDao();

    @GetMapping("/autista")
    public List<autista> visualizzaAutisti() {
        return autistaDao.visualizza();
    }

    @GetMapping("/camion")
    public List<camion> visualizzaCamion() {
        return camionDao.visualizza();
    }

    @GetMapping("/cliente")
    public List<cliente> visualizzaClienti() {
        return clienteDao.visualizza();
    }

    @GetMapping("/fornitore")
    public List<fornitore> visualizzaFornitori() {
        return fornitoreDao.visualizza();
    }

    @GetMapping("/nave")
    public List<nave> visualizzaNavi() {
        return naveDao.visualizza();
    }

    @GetMapping("/porto")
    public List<porto> visualizzaPorti() {
        return portoDao.visualizza();
    }

    @GetMapping("/viaggio")
    public List<viaggio> visualizzaViaggi() {
        return viaggioDao.visualizza();
    }

    @GetMapping("/polizza")
    public List<polizza> visualizzaPolizze() {
        return polizzaDao.visualizza();
    }

    @GetMapping("/buono")
    public List<buono> visualizzaBuoni() {
        return buonoDao.visualizza();
    }

    @GetMapping("/ritiro")
    public List<ritiro> visualizzaRitiri() {
        return ritiroDao.visualizza();
    }
}
