package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.*;

@RestController
@RequestMapping("/inserisci")
public class ControllerInserimenti {

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
    public String inserisciAutista(@RequestParam String nome, @RequestParam String username, @RequestParam String password) {
        autistaDao.inserisci(nome, username, password);
        return "Autista inserito con successo!";
    }

    @GetMapping("/camion")
    public String inserisciCamion(@RequestParam String targa, @RequestParam String modello) {
        camionDao.inserisci(targa, modello);
        return "Camion inserito con successo!";
    }

    @GetMapping("/cliente")
    public String inserisciCliente(
            @RequestParam String nome,
            @RequestParam String cognome,
            @RequestParam String mail,
            @RequestParam String tel,
            @RequestParam String password,
            @RequestParam String indirizzo) {
        clienteDao.inserisci(nome, cognome, mail, tel, password, indirizzo);
        return "Cliente inserito con successo!";
    }

    @GetMapping("/fornitore")
    public String inserisciFornitore(
            @RequestParam String nome,
            @RequestParam String cognome,
            @RequestParam String mail,
            @RequestParam String tel,
            @RequestParam String password) {
        fornitoreDao.inserisci(nome, cognome, mail, tel, password);
        return "Fornitore inserito con successo!";
    }

    @GetMapping("/nave")
    public String inserisciNave(@RequestParam String nome, @RequestParam String tipo) {
        naveDao.inserisci(nome, tipo);
        return "Nave inserita con successo!";
    }

    @GetMapping("/porto")
    public String inserisciPorto(@RequestParam String nome, @RequestParam String rotta, @RequestParam String nazione) {
        portoDao.inserisci(nome, rotta, nazione);
        return "Porto inserito con successo!";
    }

    @GetMapping("/viaggio")
    public String inserisciViaggio(
            @RequestParam int fornitore,
            @RequestParam int portoPartenza,
            @RequestParam int portoArrivo,
            @RequestParam String dataArrivo,
            @RequestParam String dataPartenza,
            @RequestParam int nave) {
        viaggioDao.inserisci(fornitore, portoPartenza, portoArrivo, dataArrivo, dataPartenza, nave);
        return "Viaggio inserito con successo!";
    }

    @GetMapping("/polizza")
    public String inserisciPolizza(
            @RequestParam int viaggio,
            @RequestParam double peso,
            @RequestParam String data,
            @RequestParam String merce,
            @RequestParam int cliente) {
        polizzaDao.inserisci(viaggio, peso, data, merce, cliente);
        return "Polizza inserita con successo!";
    }

    @GetMapping("/buono")
    public String inserisciBuono(@RequestParam String data, @RequestParam int polizza, @RequestParam double peso) {
        buonoDao.inserisci(data, polizza, peso);
        return "Buono inserito con successo!";
    }

    @GetMapping("/ritiro")
    public String inserisciRitiro(@RequestParam String camion, @RequestParam int autista, @RequestParam double peso, @RequestParam String data) {
        ritiroDao.inserisci(camion, autista, peso, data);
        return "Ritiro inserito con successo!";
    }
}
