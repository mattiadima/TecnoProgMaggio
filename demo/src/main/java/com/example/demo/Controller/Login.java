package com.example.demo.Controller;

import com.example.demo.Models.*;
import com.example.demo.Entity.utente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class Login {

    ClienteDao clienteDao = new ClienteDao();
    FornitoreDao fornitoreDao = new FornitoreDao();
    AdminDao adminDao = new AdminDao();

    @GetMapping
    public utente loginUnificato(@RequestParam String mail, @RequestParam String password) {
        utente u = clienteDao.loginCliente(mail, password);
        if (u != null) return u;

        u = fornitoreDao.loginFornitore(mail, password);
        if (u != null) return u;

        u = adminDao.loginAdmin(mail, password);
        if (u != null) return u;

        return new utente(0, mail, password);
    }
}
