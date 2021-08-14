package br.com.felipemaxplay.pringbootjpa.controller;

import br.com.felipemaxplay.pringbootjpa.model.entity.Produto;
import br.com.felipemaxplay.pringbootjpa.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController implements ProdutoControllerInt {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Produto saveProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping(path = "/letra/{firstLetra}")
    public @ResponseBody Iterable<Produto> findByFirstLetra(@PathVariable("firstLetra") String firstLetra) {
        return  produtoRepository.findByNomeStartingWith(firstLetra);
    }

    @GetMapping
    public @ResponseBody Iterable<Produto> findAllProduto() {
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public @ResponseBody Iterable<Produto> findByNome(@PathVariable("parteNome") String parteNome) {
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }


    @GetMapping("/paginas/{numPage}")
    public @ResponseBody Iterable<Produto> findPageProduto(@PathVariable("numPage") int numPage) {
        Pageable pageable = PageRequest.of(numPage, 3);
        return produtoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto> findByIdProduto(@PathVariable("id") int id){
        return produtoRepository.findById(id);
    }

    @PutMapping
    public Produto updateProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByIdProduto(@PathVariable("id") int id) {
        produtoRepository.deleteById(id);
    }
}
