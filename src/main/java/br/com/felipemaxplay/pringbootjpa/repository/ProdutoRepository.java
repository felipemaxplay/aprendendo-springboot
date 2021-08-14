package br.com.felipemaxplay.pringbootjpa.repository;

import br.com.felipemaxplay.pringbootjpa.model.entity.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    public Iterable<Produto> findByNomeStartingWith(String firstLetra);
}
