package com.example.apiLoja.service;

import com.example.apiLoja.api.model.Tags;
import com.example.apiLoja.api.model.Produtos;
import com.example.apiLoja.api.repository.TagsRepository;
import com.example.apiLoja.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsService {
    private final TagsRepository tagsRepository;
    private final ProdutosRepository produtosRepository;

    @Autowired
    public TagsService(TagsRepository tagsRepository, ProdutosRepository produtosRepository) {
        this.tagsRepository = tagsRepository;
        this.produtosRepository = produtosRepository;
    }

    public Tags saveTags(Tags tags) {
        List<Produtos> produtos = new ArrayList<>();
        for (Produtos produto : tags.getProdutos()) {
            produtos.add(produtosRepository.findById(produto.getPro_id())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado")));
        }
        tags.setProdutos(produtos);
        return tagsRepository.save(tags);
    }
}
