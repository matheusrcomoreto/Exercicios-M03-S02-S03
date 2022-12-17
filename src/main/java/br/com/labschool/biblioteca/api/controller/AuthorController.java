package br.com.labschool.biblioteca.api.controller;

import br.com.labschool.biblioteca.model.entity.Author;
import br.com.labschool.biblioteca.model.service.interfaces.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody @Valid Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.authorService.save(author));
    }

    @GetMapping
    public ResponseEntity<List<Author>> showItens(){
        return ResponseEntity.ok(this.authorService.showItens());
    }

    @PutMapping
    public ResponseEntity<Author> update(@RequestBody Author author){
        return ResponseEntity.ok(this.authorService.update(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        this.authorService.delete(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }
}
