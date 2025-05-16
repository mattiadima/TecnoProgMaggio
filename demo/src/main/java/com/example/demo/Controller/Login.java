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

    @GetMapping("/cliente")
    public utente loginCliente(@RequestParam String mail, @RequestParam String password) {
        utente u = clienteDao.loginCliente(mail, password);
        if (u != null) {
            return u;
        }
        throw new RuntimeException("Login cliente fallito.");
    }

    @GetMapping("/fornitore")
    public utente loginFornitore(@RequestParam String mail, @RequestParam String password) {
        utente u = fornitoreDao.loginFornitore(mail, password);
        if (u != null) {
            return u;
        }
        throw new RuntimeException("Login fornitore fallito.");
    }

    @GetMapping("/admin")
    public utente loginAdmin(@RequestParam String mail, @RequestParam String password) {
        utente u = adminDao.loginAdmin(mail, password);
        if (u != null) {
            return u;
        }
        throw new RuntimeException("Login admin fallito.");
    }
}
