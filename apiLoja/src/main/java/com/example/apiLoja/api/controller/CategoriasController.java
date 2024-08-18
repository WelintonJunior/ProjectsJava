package com.example.apiLoja.api.controller;

import com.example.apiLoja.api.model.Categorias;
import com.example.apiLoja.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    private final CategoriasService categoriasService;

    @Autowired
    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @PostMapping("/create")
    public Categorias createCategorias(@RequestBody Categorias categorias) {
        return categoriasService.saveCategorias(categorias);
    }
}
