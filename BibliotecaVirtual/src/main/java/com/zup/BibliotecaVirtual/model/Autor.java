package com.zup.BibliotecaVirtual.model;

import javax.persistence.*;

@Entity
public class Autor {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    //    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;
    // @Column(nullable = false) @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    // private LocalDateTime diaDoRegistro = LocalDateTime.now();

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    // public LocalDateTime getDiaDoRegistro() {
    //      return diaDoRegistro;
    // }

}
