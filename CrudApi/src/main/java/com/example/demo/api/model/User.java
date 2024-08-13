package com.example.demo.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    private int id;
    private String nome;
    private int idade;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Telefones> telefones;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Enderecos> enderecos;

    @Getter
    @Setter
    @Entity
    @Table(name = "telefones")
    public static class Telefones {
        @Id
        private int id;

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        @JsonBackReference
        private User user;

        private String numero_telefone;

    }

    @Getter
    @Setter
    @Entity
    @Table(name = "enderecos")
    public static class Enderecos {
        @Id
        private int id;

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        @JsonBackReference
        private User user;

        private String rua;
        private String cidade;
        private String estado;
        private String cep;
    }
}
