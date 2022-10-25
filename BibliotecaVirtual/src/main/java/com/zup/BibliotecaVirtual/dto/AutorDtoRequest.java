package com.zup.BibliotecaVirtual.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zup.BibliotecaVirtual.model.Autor;

public class AutorDtoRequest {

    private Long id;
    private String nome;
    private String descricao;
    //  @Column(nullable = false) @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    //private LocalDateTime diaDoRegistro;


    public AutorDtoRequest() {
    }

    public AutorDtoRequest(Autor autor){
        this.id = autor.getId();
        this.descricao = autor.getDescricao();
        this.nome = autor.getNome();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    // public LocalDateTime getDiaDoRegistro() {
    //     return diaDoRegistro;
    // }

    public static List<AutorDtoRequest> converterLista(List<Autor> autor) {
        return autor.stream().map(AutorDtoRequest::new).collect(Collectors.toList());
    }

    public Autor paraAutor(){
        return new Autor(this.nome,this.descricao);
    }
}
