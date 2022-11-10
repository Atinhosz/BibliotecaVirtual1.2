package com.zup.BibliotecaVirtual.dto;

import com.zup.BibliotecaVirtual.model.Autor;
import com.zup.BibliotecaVirtual.model.Livro;

import javax.persistence.Column;
import javax.validation.Valid;

public class LivroDtoRequest {

    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    private Autor autor;

    public LivroDtoRequest(Livro livro) {
        this.id = livro.getID();
        this.titulo = livro.getTitulo();
        this.descricao = livro.getDescricao();
        this.autor = livro.getAutor();
    }


    public Livro paraLivro(@Valid LivroDtoRequest livroDtoRequest) {
        return new Livro(this.titulo, this.descricao, this.autor);
    }
}
