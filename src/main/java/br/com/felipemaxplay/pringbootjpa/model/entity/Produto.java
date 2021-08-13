package br.com.felipemaxplay.pringbootjpa.model.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOME")
    @NotBlank
    private String nome;

    @Column(name = "PRECO")
    @Min(value = 0)
    private double preco;

    @Column(name = "DESCONTO")
    @Min(value = 0)
    @Max(value = 1)
    private double desconto;

    @Deprecated
    public Produto() {
    }

    public Produto(@NonNull String nome, double preco, double desconto) {
        this.nome = Objects.requireNonNull(nome);
        this.preco = Objects.requireNonNull(preco);
        this.desconto = Objects.requireNonNull(desconto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
