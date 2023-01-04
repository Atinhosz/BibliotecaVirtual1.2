package com.zup.BibliotecaVirtual.model;

import javax.persistence.*;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = true, length = 400)
    private String descricao;
    @ManyToOne
    private Autor autor;


    public Livro(String descricao, String isbn, Autor autor) {
    }

    public Livro(String titulo, String isbn, String descricao, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.descricao = descricao;
        this.autor = autor;
    }

    public Livro(String titulo, String isbn, String descricao, String autor){

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getID(){
        return id;
    }

    public Autor getAutor() {
        return autor;
    }
}
