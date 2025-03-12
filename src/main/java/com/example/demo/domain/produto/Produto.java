package com.example.demo.domain.produto;

import com.example.demo.dtos.ProdutoRequeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "produto")
@Entity(name = "produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private Integer preco;

    public Produto(ProdutoRequeDTO data){
        this.preco = data.price();
        this.nome = data.name();
    }
}
