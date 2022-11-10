package com.zup.BibliotecaVirtual.controller;
import com.zup.BibliotecaVirtual.dto.AutorDtoRequest;
import com.zup.BibliotecaVirtual.dto.AutorDtoResponse;
import com.zup.BibliotecaVirtual.model.Autor;
import com.zup.BibliotecaVirtual.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;


@RestController
@RequestMapping(value = "/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDtoRequest> criar(@RequestBody @Valid AutorDtoRequest autorDtoRequest, UriComponentsBuilder uriComponentsBuilder){
        Autor autor = autorDtoRequest.paraAutor(autorDtoRequest);
        Autor salvarAutor = autorRepository.save(autor);
        URI uri = uriComponentsBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{autor}")
    public ResponseEntity<AutorDtoResponse> lista(@PathVariable String nome){
        Optional<Autor> autor = autorRepository.findByNome(nome);
        return ResponseEntity.ok(new AutorDtoResponse(autor));
    }

}
