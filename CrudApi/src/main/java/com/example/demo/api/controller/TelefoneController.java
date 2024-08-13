package com.example.demo.api.controller;

import com.example.demo.api.model.Telefones;
import com.example.demo.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    private final TelefoneService telefoneService;

    @Autowired
    public TelefoneController(TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    @PostMapping("/create")
    public Telefones createTelefone(@RequestBody Telefones telefone) {
        return telefoneService.saveTelefone(telefone);
    }

    @GetMapping("/{id}")
    public Telefones findTelefone(@PathVariable int id) {
        return telefoneService.getTelefoneById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTelefoneById(@PathVariable int id) { telefoneService.deleteTelefoneById(id);
    }

    @PutMapping("/update/{id}")
    public Telefones updateTelefoneById(@PathVariable int id, @RequestBody Telefones telefone) {
        return telefoneService.updateTelefoneById(id, telefone);
    }
}
