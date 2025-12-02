package com.fiap.tc2sub.Biblioteca.controller;

import com.fiap.tc2sub.Biblioteca.dto.livro.request.LivroPostRequestDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.request.LivroPutRequestDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.response.LivroPostResponseDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.response.LivroPutResponseDTO;
import com.fiap.tc2sub.Biblioteca.mappers.LivroMapper;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.livro.Page;
import com.fiap.tc2sub.Biblioteca.usecase.livro.DeleteLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.livro.EditLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.livro.FindLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.livro.SaveLivroUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/livro")
@RequiredArgsConstructor
public class LivroController {

    private final SaveLivroUseCase saveLivroUseCase;
    private final DeleteLivroUseCase deleteLivroUseCase;
    private final EditLivroUseCase editLivroUseCase;
    private final FindLivroUseCase findLivroUseCase;

    @PostMapping
    public ResponseEntity<LivroPostResponseDTO> save(@RequestBody @Valid LivroPostRequestDTO livro) throws Exception {
        return ResponseEntity.ok(LivroMapper.INSTANCE.toLivroPostResponseDTO(saveLivroUseCase.save(LivroMapper.INSTANCE.toLivro(livro))));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Livro> findIsbn(@PathVariable String isbn) {
        Livro livro = findLivroUseCase.findIsbn(Livro.validarIsbn(isbn)).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<Page<Livro>> findAutor(
            @PathVariable String autor,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(findLivroUseCase.findAutor(autor, page, size));
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Page<Livro>> findTitulo(
            @PathVariable String titulo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(findLivroUseCase.findTitulo(titulo, page, size));
    }

    @GetMapping("/editora/{editora}")
    public ResponseEntity<Page<Livro>> findEditora(
            @PathVariable String editora,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(findLivroUseCase.findEditora(editora, page, size));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> delete(@PathVariable String isbn) throws Exception {
        deleteLivroUseCase.delete(isbn);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<LivroPutResponseDTO> edit(@PathVariable String isbn, @RequestBody LivroPutRequestDTO livro) throws Exception {
        findLivroUseCase.findIsbn(isbn).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return ResponseEntity.ok(LivroMapper.INSTANCE.toLivroPutResponseDTO(editLivroUseCase.editLivro(new Livro(isbn, livro.titulo(),livro.autor(), livro.editora(), livro.quantidade()))));
    }
}
