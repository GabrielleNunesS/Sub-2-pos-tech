package com.fiap.tc2sub.Biblioteca.model.livro;

import com.fiap.tc2sub.Biblioteca.exceptions.IsbnInvalidException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private int quantidade;

    public Livro(String isbn, String titulo, String autor, String editora, int quantidade) {
        this.isbn = validarIsbn(isbn);
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.quantidade = validarQuantidade(quantidade);
    }

    /**
     * Valida o ISBN fornecido e o retorna em um formato normalizado.
     *
     * @param isbn O ISBN a ser validado.
     * @return O ISBN normalizado (apenas dígitos).
     * @throws IsbnInvalidException se o ISBN for nulo, vazio ou inválido.
     */
    public static String validarIsbn(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IsbnInvalidException("ISBN não pode ser nulo ou vazio");
        }

        if (!isbn.matches("\\d{9}[\\dX]|\\d{13}")) {
            throw new IsbnInvalidException("ISBN deve ter 10 ou 13 dígitos");
        }

        switch (isbn.length()) {
            case 10:
                if (!verificaValidadeIsbn10(isbn)) {
                    throw new IsbnInvalidException("ISBN-10 inválido");
                }
                break;
            case 13:
                if (!verificaValidadeIsbn13(isbn)) {
                    throw new IsbnInvalidException("ISBN-13 inválido");
                }
                break;
            default:
                throw new IsbnInvalidException("ISBN deve ter 10 ou 13 dígitos");
        }

        return isbn;
    }

    /**
     * Verifica a validade do ISBN-13.
     *
     * @param isbn O ISBN-13 a ser verificado.
     * @return true se o ISBN-13 for válido, false caso contrário.
     */
    private static boolean verificaValidadeIsbn13(String isbn) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = isbn.charAt(i) - '0';
            sum += digit * (i % 2 == 0 ? 1 : 3);
        }

        int checksum = (10 - (sum % 10)) % 10;
        return checksum == (isbn.charAt(12) - '0');
    }

    /**
     * Verifica a validade do ISBN-10.
     *
     * @param isbn O ISBN-10 a ser verificado.
     * @return true se o ISBN-10 for válido, false caso contrário.
     */
    private static boolean verificaValidadeIsbn10(String isbn) {
        if (!isbn.matches("\\d{9}[\\dX]")) {
            return false; // Must be 9 digits followed by a digit or 'X'
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (isbn.charAt(i) - '0') * (i + 1);
        }

        char checksumChar = isbn.charAt(9);
        int checksum = (checksumChar == 'X') ? 10 : (checksumChar - '0');
        sum += checksum * 10;

        return sum % 11 == 0;
    }

    private static Integer validarQuantidade(Integer quantidade ) {
        if (quantidade == null || quantidade < 0) {
            throw new IllegalArgumentException("Quantidade deve ser um número inteiro positivo");
        }

        return quantidade;
    }
}
