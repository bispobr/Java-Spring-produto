package com.example.demo.dtos;

import com.example.demo.domain.produto.Produto;

public record ProdutoRespostaDTO(String id, String nome, Integer preco) {
    public ProdutoRespostaDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getPreco());
    }
}
