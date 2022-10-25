package com.zup.BibliotecaVirtual.repository;

import com.zup.BibliotecaVirtual.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNome(String nome);

}
