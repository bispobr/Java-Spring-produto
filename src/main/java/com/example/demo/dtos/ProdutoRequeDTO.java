package com.example.demo.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequeDTO(@NotBlank String nome, @NotNull Integer preco) {
}
