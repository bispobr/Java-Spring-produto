package com.example.demo.dtos;

import com.example.demo.domain.user.UsuarioPermissao;

public record RegistroDTO(String login, String Senha, UsuarioPermissao permissao) {
}
