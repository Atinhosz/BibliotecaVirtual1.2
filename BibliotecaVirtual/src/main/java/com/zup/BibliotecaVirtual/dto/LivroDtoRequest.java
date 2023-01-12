package com.zup.BibliotecaVirtual.dto;

import com.zup.BibliotecaVirtual.model.Autor;
import com.zup.BibliotecaVirtual.model.Livro;
import com.zup.BibliotecaVirtual.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroDtoRequest {

    @Autowired
    private AutorRepository autorRepository;

    private Long id;
    private String titulo;
    private String isbn;
    private String descricao;
    private String autor;


    public LivroDtoRequest(){
    }

    public LivroDtoRequest(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.titulo = livro.getIsbn();
        this.descricao = livro.getDescricao();
        this.autor = livro.getAutor().getNome();
    }

    public static List<LivroDtoRequest> converterLista(List<Livro> livro) {
        return livro.stream().map(LivroDtoRequest::new).collect(Collectors.toList());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutor(){
        return autor;
   }


    public Livro paraLivro(@Valid LivroDtoRequest livroDtoRequest, Autor buscarAutor) {
        return new Livro(livroDtoRequest.getTitulo(),livroDtoRequest.getIsbn(),livroDtoRequest.getDescricao(),buscarAutor);
    }



}
