package br.com.felipemaxplay.pringbootjpa.controller;

import br.com.felipemaxplay.pringbootjpa.model.entity.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

public interface ProdutoControllerInt {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Produto saveProduto(@Valid Produto produto);

    @GetMapping
    Iterable<Produto> findAllProduto();

    @GetMapping("/{id}")
    Optional<Produto> findByIdProduto(@PathVariable("id") int id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteByIdProduto(@PathVariable("id") int id);

    @PutMapping
    Produto updateProduto(@Valid Produto produto);
}
