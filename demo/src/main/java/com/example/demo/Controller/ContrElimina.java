package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.AutistaDao;


@RestController
@RequestMapping("/elimina")
public class ContrElimina {

    AutistaDao dao = new AutistaDao();

    @GetMapping("/autista")
    public String eliminaAutista(@RequestParam int id) {
        dao.cancella(id);
        return "Autista con ID " + id + " eliminato con successo!";
    }
}
