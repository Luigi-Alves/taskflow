package com.taskflow.taskflow.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private LocalDate prazo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public LocalDate getPrazo() {

        return prazo;
    }

    public void setPrazo(LocalDate prazo) {

        this.prazo = prazo;
    }

    public Prioridade getPrioridade() {

        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {

        this.prioridade = prioridade;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    public String getTitulo() {

        return titulo;
    }


    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }
}
