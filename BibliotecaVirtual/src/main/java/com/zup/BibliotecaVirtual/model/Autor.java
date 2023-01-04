package com.zup.BibliotecaVirtual.model;

import javax.persistence.*;

@Entity
public class Autor {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;

    public Autor() {
    }

    public Autor(String nome, String descricao, String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;

    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {return email; }

}
