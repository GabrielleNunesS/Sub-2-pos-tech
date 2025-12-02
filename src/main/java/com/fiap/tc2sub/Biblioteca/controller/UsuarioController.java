package com.fiap.tc2sub.Biblioteca.controller;

import com.fiap.tc2sub.Biblioteca.dto.livro.request.LivroPostRequestDTO;
import com.fiap.tc2sub.Biblioteca.dto.usuario.request.UsuarioPostRequestDTO;
import com.fiap.tc2sub.Biblioteca.mappers.UsuarioMapper;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.DeleteUsuarioUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.EditUsuarioUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.FindUsuarioUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.SaveUsuarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final SaveUsuarioUseCase saveUsuarioUseCase;
    private final DeleteUsuarioUseCase deleteUsuarioUseCase;
    private final EditUsuarioUseCase editUsuarioUseCase;
    private final FindUsuarioUseCase findUsuarioUseCase;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioPostRequestDTO usuario) throws Exception {
        return ResponseEntity.ok(saveUsuarioUseCase.save(UsuarioMapper.INSTANCE.usuarioPostRequestDTOToUsuario(usuario)));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> find(@PathVariable String email) throws Exception {
        return findUsuarioUseCase.findUsuario(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Usuario> findNome(@PathVariable String nome) throws Exception {
        return findUsuarioUseCase.findUsuarioNome(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) throws Exception {
        deleteUsuarioUseCase.delete(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{email}")
    public ResponseEntity<Usuario> edit(@RequestBody UsuarioPostRequestDTO usuario) throws Exception {
        return ResponseEntity.ok(editUsuarioUseCase.editUsuario(Usuario.validaEmailUsuario(usuario.email()), UsuarioMapper.INSTANCE.usuarioPostRequestDTOToUsuario(usuario)));
    }
}
