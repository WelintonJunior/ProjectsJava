package com.example.apiLoja.api.controller;

import com.example.apiLoja.api.model.Produtos;
import com.example.apiLoja.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    private final ProdutosService produtosService;

    @Autowired
    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }
    
    @PostMapping("/create")
    public Produtos createProduto(@RequestBody Produtos produto) {
        return produtosService.saveProdutos(produto);
    }

    @GetMapping("/getAll")
    public List<Produtos> getAllProdutos() {
        return produtosService.getProdutos();
    }
}
