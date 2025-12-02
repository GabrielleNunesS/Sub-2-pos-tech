package com.fiap.tc2sub.Biblioteca.model.usuario;

import com.fiap.tc2sub.Biblioteca.exceptions.UsuarioException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String email;
    private String nome;
    private String telefone;

    public Usuario(String email, String nome, String telefone) {
        this.email = validaEmailUsuario(email);
        this.nome = validaNomeUsuario(nome);
        this.telefone = validaTelefoneUsuario(telefone);
    }


    public static String validaEmailUsuario(String email) {
        if (email == null || email.isEmpty() || email.indexOf("@") == 0 || !email.contains("@") || !email.contains(".") || email.length() < 5 || email.length() > 50) {
            throw new UsuarioException("Email inválido");
        }
        return email;
    }

    public static String validaNomeUsuario(String nome) {
        if (nome == null || nome.length() < 3 || nome.length() > 50) {
            throw new UsuarioException("Nome inválido");
        }
        return nome;
    }

    public static String validaTelefoneUsuario(String telefone) {
        if (telefone == null || telefone.length() < 10 || telefone.length() > 16) {
            throw new UsuarioException("Telefone inválido");
        }
        return telefone;
    }
}
