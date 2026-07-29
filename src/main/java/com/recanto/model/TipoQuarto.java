package com.recanto.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quarto")
public class TipoQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(name = "preco_diaria", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoDiaria;

    @OneToMany(mappedBy = "tipoQuarto", cascade = CascadeType.ALL)
    private List<Quarto> quartos = new ArrayList<>();

    public TipoQuarto() {
    }

    public TipoQuarto(String nome, String descricao, BigDecimal precoDiaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoDiaria = precoDiaria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }





}
