package com.example.demo.controllers;

import com.example.demo.domain.user.Usuario;
import com.example.demo.dtos.AutenticacaoDTO;
import com.example.demo.dtos.LoginRespostaDTO;
import com.example.demo.dtos.RegistroDTO;
import com.example.demo.infra.security.TokenServico;
import com.example.demo.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")

public class AutenticacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServico tokenServico;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data){
        var usuarioNomeSenha = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usuarioNomeSenha);

        var token = tokenServico.geradorToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginRespostaDTO(token));
    }

    @PostMapping("/registro")
    public ResponseEntity registro(@RequestBody @Valid RegistroDTO data){
        if(this.usuarioRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String senhaEncriptada = new BCryptPasswordEncoder().encode(data.Senha());
        Usuario novoUsuario = new Usuario(data.login(), senhaEncriptada, data.permissao());

        this.usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }
}
