package br.com.felipemaxplay.pringbootjpa.controller;

import br.com.felipemaxplay.pringbootjpa.model.entity.Produto;
import br.com.felipemaxplay.pringbootjpa.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public @ResponseBody Produto saveProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

}
