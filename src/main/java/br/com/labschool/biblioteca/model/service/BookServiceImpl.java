package br.com.labschool.biblioteca.model.service;

import br.com.labschool.biblioteca.model.entity.Book;
import br.com.labschool.biblioteca.model.repository.BookRepository;
import br.com.labschool.biblioteca.model.service.interfaces.BookService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        String title = book.getTitle().toLowerCase();

        validName(title);
        book.setTitle(title);
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> showItens() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book update(Book book) {
        Book bookSearch = search(book.getId());

        if (Objects.nonNull(book)) {
            book.setTitle(book.getTitle().toLowerCase());
            BeanUtils.copyProperties(book, bookSearch, "id");
            validName(bookSearch.getTitle().toLowerCase());
            this.bookRepository.save(bookSearch);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book search(Long id) {
        Optional<Book> bookSearch = this.bookRepository.findById(id);

        if (bookSearch.isEmpty()) {
            throw new EntityNotFoundException("Não foi possivel encontrar um produto com o id: " + id);
        }
        return bookSearch.get();
    }

    private void validName(String title) {
        if (this.bookRepository.existsByTitle(title)) {
            throw new EntityExistsException("Já existe um departamento com esse nome: " + title);
        }
    }
}
