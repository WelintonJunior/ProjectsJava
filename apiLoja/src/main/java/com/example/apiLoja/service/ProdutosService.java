package com.example.apiLoja.service;

import com.example.apiLoja.api.model.Produtos;
import com.example.apiLoja.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    @Autowired
    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public Produtos saveProdutos(Produtos produtos) {
        return produtosRepository.save(produtos);
    }

    public List<Produtos> getProdutos() {
    return produtosRepository.findAll();
    }

}
