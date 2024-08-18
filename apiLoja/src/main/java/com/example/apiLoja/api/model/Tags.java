package com.example.apiLoja.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tblTagsProdutos")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tag_id;
    private String tag_nome;

    @ManyToMany
    @JoinTable(
            name = "tblIdTagsProdutos",
            joinColumns = @JoinColumn(name = "fk_tagId"),
            inverseJoinColumns = @JoinColumn(name = "fk_proId")
    )
    private List<Produtos> produtos;
}
