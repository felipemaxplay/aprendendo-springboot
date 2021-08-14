package br.com.felipemaxplay.pringbootjpa.controller;

import br.com.felipemaxplay.pringbootjpa.model.entity.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

public interface ProdutoControllerInt {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto(@Valid Produto produto);

    @GetMapping
    public Iterable<Produto> findAllProduto();

    @GetMapping(path = "/{firstLetra}")
    public @ResponseBody Iterable<Produto> findByFirstLetra(@PathVariable("firstLetra") String firstLetra);

    @GetMapping(path = "/{parteNome}")
    public @ResponseBody Iterable<Produto> findByNome(@PathVariable("parteNome") String parteNome);

    @GetMapping("/paginas/{numPage}")
    public Iterable<Produto> findPageProduto(@PathVariable("numPage") int numPage);

    @GetMapping("/{id}")
    public Optional<Produto> findByIdProduto(@PathVariable("id") int id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByIdProduto(@PathVariable("id") int id);

    @PutMapping
    public Produto updateProduto(@Valid Produto produto);
}
