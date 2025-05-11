package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.autista;
import com.example.demo.Models.AutistaDao;

@RestController
@RequestMapping("/visualizza")
public class ContrVisualizza {

    AutistaDao dao = new AutistaDao();

     @GetMapping("/autista")
    public List<autista> visualizzaAutisti() {
        return dao.visualizza();  // Restituisce la lista di autisti in formato JSON
    }
}
