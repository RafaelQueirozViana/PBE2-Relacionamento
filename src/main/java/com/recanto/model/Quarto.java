package com.recanto.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer andar;

    @Column(nullable = false)
    private Integer capacidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_quarto_id", nullable = false)
    private TipoQuarto tipoQuarto;

    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    public Quarto() {
    }

    public Quarto(Integer numero, Integer andar, Integer capacidade, TipoQuarto tipoQuarto) {
        this.numero = numero;
        this.andar = andar;
        this.capacidade = capacidade;
        this.tipoQuarto = tipoQuarto;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}