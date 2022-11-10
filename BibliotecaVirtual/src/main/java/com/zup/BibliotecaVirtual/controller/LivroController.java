package com.zup.BibliotecaVirtual.controller;

import com.zup.BibliotecaVirtual.dto.LivroDtoRequest;
import com.zup.BibliotecaVirtual.model.Livro;
import com.zup.BibliotecaVirtual.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import javax.validation.Valid;


@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<LivroDtoRequest> criar(@RequestBody @Valid LivroDtoRequest livroDtoRequest,  UriComponentsBuilder uriComponentsBuilder){
        Livro livro = livroDtoRequest.paraLivro();
        Livro salvarLivro = livroRepository.save(livro);
        URI uri = uriComponentsBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }





}
