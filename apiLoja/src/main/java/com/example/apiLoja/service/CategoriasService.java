package com.example.apiLoja.service;

import com.example.apiLoja.api.model.Categorias;
import com.example.apiLoja.api.model.Produtos;
import com.example.apiLoja.api.repository.CategoriasRepository;
import com.example.apiLoja.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriasService {
    private final CategoriasRepository categoriasRepository;
    private final ProdutosRepository produtosRepository;

    @Autowired
    public CategoriasService(CategoriasRepository categoriasRepository, ProdutosRepository produtosRepository) {
        this.categoriasRepository = categoriasRepository;
        this.produtosRepository = produtosRepository;
    }

    public Categorias saveCategorias(Categorias categorias) {
        List<Produtos> produtos = new ArrayList<>();
        for (Produtos produto : categorias.getProdutos()) {
            produtos.add(produtosRepository.findById(produto.getPro_id())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado")));
        }
        categorias.setProdutos(produtos);
        return categoriasRepository.save(categorias);
    }
}
