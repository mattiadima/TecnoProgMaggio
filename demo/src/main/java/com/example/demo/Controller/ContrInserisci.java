package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.AutistaDao;

@RestController
@RequestMapping("/inserisci")
public class ContrInserisci {

    AutistaDao dao = new AutistaDao(); 

    @GetMapping("/autista")
    public String inserisciAutista(
            @RequestParam String nome,
            @RequestParam String username,
            @RequestParam String password) {

        dao.inserisci(nome, username, password);
        return "Autista inserito con successo!";
    }
}

