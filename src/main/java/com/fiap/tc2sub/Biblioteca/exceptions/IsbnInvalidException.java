package com.fiap.tc2sub.Biblioteca.exceptions;

/**
 * Exceção personalizada para erros relacionados a ISBN inválido.
 */
public class IsbnInvalidException extends RuntimeException {

    /**
     * Construtor padrão sem mensagem.
     */
    public IsbnInvalidException() {
        super();
    }

    /**
     * Construtor com uma mensagem personalizada.
     *
     * @param mensagem A mensagem de erro.
     */
    public IsbnInvalidException(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor com uma mensagem personalizada e a causa do erro.
     *
     * @param mensagem A mensagem de erro.
     * @param causa    A causa do erro.
     */
    public IsbnInvalidException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * Construtor com a causa do erro.
     *
     * @param causa A causa do erro.
     */
    public IsbnInvalidException(Throwable causa) {
        super(causa);
    }
}
