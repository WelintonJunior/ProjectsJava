package com.example.demo.api.controller;

import com.example.demo.api.model.Enderecos;
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
    public Enderecos createEndereco(@RequestBody Enderecos enderecos) {
        return enderecoService.saveEndereco(enderecos);
    }

    @GetMapping("/{id}")
    public Enderecos findEndereco(@PathVariable int id) {
        return enderecoService.getEnderecoById(id);
    }
}
