package com.zup.BibliotecaVirtual.dto;

import com.zup.BibliotecaVirtual.model.Autor;
import com.zup.BibliotecaVirtual.model.Livro;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

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


    public Livro paraLivro() {
        return new Livro(this.titulo, this.descricao, this.autor);
    }
}
