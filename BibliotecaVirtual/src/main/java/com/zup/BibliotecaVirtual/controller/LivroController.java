package com.zup.BibliotecaVirtual.controller;

import com.zup.BibliotecaVirtual.dto.LivroDtoRequest;
import com.zup.BibliotecaVirtual.dto.LivroDtoResponse;
import com.zup.BibliotecaVirtual.model.Autor;
import com.zup.BibliotecaVirtual.model.Livro;
import com.zup.BibliotecaVirtual.repository.AutorRepository;
import com.zup.BibliotecaVirtual.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.management.Query;
import javax.validation.Valid;


@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<LivroDtoRequest> criar(@RequestBody @Valid LivroDtoRequest livroDtoRequest,  UriComponentsBuilder uriComponentsBuilder){
        Optional<Autor> buscaAutor = autorRepository.findByNome(livroDtoRequest.getAutor());
        if(!buscaAutor.isPresent()){
          return ResponseEntity.notFound().build();
        }
        Livro livro = livroDtoRequest.paraLivro(livroDtoRequest,buscaAutor.get());
        Livro salvarLivro = livroRepository.save(livro);
        URI uri = uriComponentsBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Livro> lista(@RequestParam(name = "isbn")String isbn){
            Optional<Livro> livro = livroRepository.findByIsbn(isbn);
        if(!livro.isPresent()){
            return ResponseEntity.notFound().build();
        }
        System.out.println(livro.get());
        return new ResponseEntity<Livro>(livro.get() , HttpStatus.OK);
    }




/*
    {
        "titulo":"",
            "isbn":"",
            "descricao":"",
            "autor":""
    }
*/

}
