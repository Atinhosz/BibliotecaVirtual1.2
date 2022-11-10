package com.zup.BibliotecaVirtual.dto;

import com.zup.BibliotecaVirtual.model.Autor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AutorDtoResponse {
    private Long id;
    private String nome;
    private String descricao;



    public
    AutorDtoResponse(Autor autor){
        this.id = autor.getId();
        this.descricao = autor.getDescricao();
        this.nome = autor.getNome();
    }

    public AutorDtoResponse(Optional<Autor> autor) {
        this.id = autor.get().getId();
        this.nome = autor.get().getNome();
        this.descricao = autor.get().getDescricao();
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
    

    public static List<AutorDtoResponse> converterLista(List<Autor> autor) {
        return autor.stream().map(AutorDtoResponse::new).collect(Collectors.toList());
    }
}
