package br.com.labschool.biblioteca.api.controller;

import br.com.labschool.biblioteca.model.entity.Book;
import br.com.labschool.biblioteca.model.service.interfaces.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.save(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> showItens () {
        return ResponseEntity.ok(this.bookService.showItens());
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book){
        return ResponseEntity.ok(this.bookService.update(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> search(@PathVariable Long id){
        Book book = this.bookService.search(id);
        return ResponseEntity.ok(this.bookService.search(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.bookService.delete(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }
}
