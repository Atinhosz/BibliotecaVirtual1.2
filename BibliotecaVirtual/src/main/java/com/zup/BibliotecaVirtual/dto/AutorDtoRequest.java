package com.zup.BibliotecaVirtual.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zup.BibliotecaVirtual.model.Autor;

import javax.validation.constraints.Email;

public class AutorDtoRequest {

    private Long id;
    private String nome;
    private String descricao;
    @Email
    private String email;

    public AutorDtoRequest() {
    }

    public AutorDtoRequest(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
        this.email = autor.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() { return email; }

    public static List<AutorDtoRequest> converterLista(List<Autor> autor) {
        return autor.stream().map(AutorDtoRequest::new).collect(Collectors.toList());
    }

    public Autor paraAutor(AutorDtoRequest autorDtoRequest){
        return new Autor(autorDtoRequest.getNome(), autorDtoRequest.getDescricao(), autorDtoRequest.getEmail());
    }


}
