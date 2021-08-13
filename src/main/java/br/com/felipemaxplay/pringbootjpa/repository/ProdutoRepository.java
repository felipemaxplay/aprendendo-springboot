package br.com.felipemaxplay.pringbootjpa.repository;

import br.com.felipemaxplay.pringbootjpa.model.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
