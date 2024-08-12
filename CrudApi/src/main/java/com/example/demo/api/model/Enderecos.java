package com.example.demo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "enderecos")
public class Enderecos {
    @Id
    private int id;
    private int usuario_id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
}
