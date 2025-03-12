package com.example.demo.controllers;
import com.example.demo.domain.produto.Produto;
import com.example.demo.dtos.ProdutoRequeDTO;
import com.example.demo.dtos.ProdutoRespostaDTO;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController()
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity postProduto(@RequestBody @Valid ProdutoRequeDTO body){
        Produto novoProduto = new Produto(body);

        this.produtoRepository.save(novoProduto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getTodosProdutos(){
        List<ProdutoRespostaDTO> productList = this.produtoRepository.findAll().stream().map(ProdutoRespostaDTO::new).toList();

        return ResponseEntity.ok(productList);
    }
}
