package com.zup.BibliotecaVirtual.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Livro {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false, length = 400)
    private String descricao;
    @Column(nullable = false) @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private LocalDateTime diaDoRegistro = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro(){
    }

    public Livro(String titulo, String isbn, String descricao, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.descricao = descricao;
        this.autor = autor;
    }

    public LocalDateTime getDiaDoRegistro() {
        return diaDoRegistro;
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
