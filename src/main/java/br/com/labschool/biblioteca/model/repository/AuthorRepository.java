package br.com.labschool.biblioteca.model.repository;

import br.com.labschool.biblioteca.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author, Long> {

    Boolean existsByName (String name);
}
