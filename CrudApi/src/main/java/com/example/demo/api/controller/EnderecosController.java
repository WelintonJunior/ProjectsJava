package com.example.demo.api.controller;

import com.example.demo.api.model.User;
import com.example.demo.service.EnderecosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {
    private final EnderecosService enderecoService;

    @Autowired
    public EnderecosController(EnderecosService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping("/create")
    public User.Enderecos createEndereco(@RequestBody User.Enderecos enderecos) {
        return enderecoService.saveEndereco(enderecos);
    }

    @GetMapping("/{id}")
    public User.Enderecos findEndereco(@PathVariable int id) {
        return enderecoService.getEnderecoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEndereco(@PathVariable int id) {
        enderecoService.deleteEnderecoById(id);
    }

    @PutMapping("/update/{id}")
    public User.Enderecos updateEndereco(@PathVariable int id, @RequestBody User.Enderecos enderecos) {
        return enderecoService.updateEnderecoById(id, enderecos);
    }
}
