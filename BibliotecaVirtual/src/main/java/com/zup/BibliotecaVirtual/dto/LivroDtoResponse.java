package com.zup.BibliotecaVirtual.dto;

import com.zup.BibliotecaVirtual.model.Autor;
import com.zup.BibliotecaVirtual.model.Livro;

import java.util.List;

public class LivroDtoResponse {

    private Long id;
    private String descricao;
    private String isbn;
    private String autor;

    public LivroDtoResponse(Livro livro) {
        this.id = livro.getId();
        this.descricao = livro.getDescricao();
        this.isbn = livro.getIsbn();
        this.autor = livro.getAutor().getNome();
    }


    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

}
