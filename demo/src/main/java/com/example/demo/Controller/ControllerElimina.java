package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.*;

@RestController
@RequestMapping("/elimina")
public class ControllerElimina {

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

    @DeleteMapping("/autista")
    public String eliminaAutista(@RequestParam int id) {
        autistaDao.cancella(id);
        return "Autista eliminato con successo!";
    }

    @DeleteMapping("/camion")
    public String eliminaCamion(@RequestParam String targa) {
        camionDao.cancella(targa);
        return "Camion eliminato con successo!";
    }

    @DeleteMapping("/cliente")
    public String eliminaCliente(@RequestParam int id) {
        clienteDao.cancella(id);
        return "Cliente eliminato con successo!";
    }

    @DeleteMapping("/fornitore")
    public String eliminaFornitore(@RequestParam int id) {
        fornitoreDao.cancella(id);
        return "Fornitore eliminato con successo!";
    }

    @DeleteMapping("/nave")
    public String eliminaNave(@RequestParam int id) {
        naveDao.cancella(id);
        return "Nave eliminata con successo!";
    }

    @DeleteMapping("/porto")
    public String eliminaPorto(@RequestParam int id) {
        portoDao.cancella(id);
        return "Porto eliminato con successo!";
    }

    @DeleteMapping("/viaggio")
    public String eliminaViaggio(@RequestParam int id) {
        viaggioDao.cancella(id);
        return "Viaggio eliminato con successo!";
    }

    @DeleteMapping("/polizza")
    public String eliminaPolizza(@RequestParam int id) {
        polizzaDao.cancella(id);
        return "Polizza eliminata con successo!";
    }

    @DeleteMapping("/buono")
    public String eliminaBuono(@RequestParam int id) {
        buonoDao.cancella(id);
        return "Buono eliminato con successo!";
    }

    @DeleteMapping("/ritiro")
    public String eliminaRitiro(@RequestParam int id) {
        ritiroDao.cancella(id);
        return "Ritiro eliminato con successo!";
    }
}
