package br.com.labschool.biblioteca.model.service;

import br.com.labschool.biblioteca.model.entity.Author;
import br.com.labschool.biblioteca.model.repository.AuthorRepository;
import br.com.labschool.biblioteca.model.service.interfaces.AuthorService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        String name = author.getName().toLowerCase();

        validName(name);
        author.setName(name);
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> showItens() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author update(Author author) {
        Author authorSearch = search(author.getId());

        if(Objects.nonNull(author)) {
            author.setName(author.getName().toLowerCase());
            BeanUtils.copyProperties(author,authorSearch,"id");
            validName(authorSearch.getName().toLowerCase());
            this.authorRepository.save(authorSearch);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        this.authorRepository.deleteById(id);

    }

    @Override
    public Author search(Long id) {
        Optional<Author> authorSearch = this.authorRepository.findById(id);

        if(authorSearch.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel encontrar um departamneto com o id: " + id);
        }
        return authorSearch.get();
    }

    private void validName (String name){
        if (this.authorRepository.existsByName(name)) {
            throw new EntityExistsException("Já existe um departamento com esse nome: " + name);
        }
    }
}
