package com.example.apiLoja.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tblCategoriasProdutos")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cat_id;
    private String cat_nome;

    @ManyToMany
    @JoinTable(
            name = "tblIdCategoriasProdutos",
            joinColumns = @JoinColumn(name = "fk_catId"),
            inverseJoinColumns = @JoinColumn(name = "fk_proId")
    )
    private List<Produtos> produtos;
}
