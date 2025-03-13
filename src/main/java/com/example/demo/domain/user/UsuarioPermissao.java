package com.example.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsuarioPermissao {

    ADMIN("admin"),
    USER("user");

    private String permissao;


}
