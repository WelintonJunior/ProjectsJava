package com.example.apiLoja.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblProdutos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pro_id;
    private String pro_nome;
    private String pro_descAmostra;
    private String pro_descCompleta;
    private double pro_preco;
}
